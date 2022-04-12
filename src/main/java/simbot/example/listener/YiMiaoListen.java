package simbot.example.listener;

import com.alibaba.fastjson.JSONObject;
import love.forte.simbot.annotation.Filter;
import love.forte.simbot.annotation.OnGroup;
import love.forte.simbot.api.message.events.GroupMsg;
import love.forte.simbot.api.sender.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import simbot.example.dao.YiMiaoDao;
import simbot.example.domain.YiMiao;
import simbot.example.http.HttpClientDemo;
import simbot.example.task.RunTimeAddSchedule;
import simbot.example.utils.YiMiaoUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class YiMiaoListen {
    private final YiMiaoDao yiMiaoDao;
    private final HttpClientDemo httpClientDemo;
    private final RunTimeAddSchedule runTimeAddSchedule;

    @Autowired
    public YiMiaoListen(YiMiaoDao yiMiaoDao, HttpClientDemo httpClientDemo, RunTimeAddSchedule runTimeAddSchedule) {
        this.yiMiaoDao = yiMiaoDao;
        this.httpClientDemo = httpClientDemo;
        this.runTimeAddSchedule = runTimeAddSchedule;
    }


    @OnGroup
    @Filter("查询")
    public void selectYiMiao(GroupMsg msg, Sender sender) {
        try {
            List<YiMiao> yiMiaosHttp = JSONObject.parseObject(httpClientDemo.getLocation()).getJSONObject("data").getJSONObject("website").getJSONArray("place").toJavaList(YiMiao.class);
            List<YiMiao> yiMiaosDB = yiMiaoDao.selectList(null);
            YiMiaoUtils.yiMiaoDeleteByTimeForDB(yiMiaosDB);
            YiMiaoUtils.yiMiaoDeleteByTimeForHttp(yiMiaosHttp);
            for (YiMiao yiMiao : yiMiaosDB) {
                sender.sendGroupMsg(msg, yiMiao.toString());
            }
            yiMiaosHttp.removeAll(yiMiaosDB);
            if (!yiMiaosHttp.isEmpty()) {
                for (YiMiao yiMiao : yiMiaosHttp) {
                    sender.sendGroupMsg(msg, "新增疫苗:\n" + yiMiao.toString());
                    setRunTimeAddSchedule(yiMiao, yiMiaoDao, runTimeAddSchedule);
                }
            }
            if (yiMiaosDB.isEmpty()&&yiMiaosHttp.isEmpty()){
                sender.sendGroupMsg(msg,"当前没有疫苗");
            }
        } catch (ParseException e) {
            e.printStackTrace();
            sender.sendGroupMsg(msg, e.getMessage());
        }
    }

    public static void setRunTimeAddSchedule(YiMiao yiMiao, YiMiaoDao yiMiaoDao, RunTimeAddSchedule runTimeAddSchedule) throws ParseException {
        yiMiaoDao.insert(yiMiao);
        Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(yiMiao.getYyTime());
        date.setTime(date.getTime() - 1000L * 60L * 5L);
        runTimeAddSchedule.setScheduler(date, yiMiao);
        date.setTime(date.getTime() - 1000L * 60L * 5L);
        runTimeAddSchedule.setScheduler(date, yiMiao);
    }
}
