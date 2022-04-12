package simbot.example.task;

import com.alibaba.fastjson.JSONObject;
import love.forte.simbot.bot.BotManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import simbot.example.dao.YiMiaoDao;
import simbot.example.domain.YiMiao;
import simbot.example.http.HttpClientDemo;
import simbot.example.listener.YiMiaoListen;
import simbot.example.utils.YiMiaoUtils;

import java.text.ParseException;
import java.util.List;

@Component
public class MyTask {
    private RunTimeAddSchedule runTimeAddSchedule;
    private HttpClientDemo httpClientDemo;
    private YiMiaoDao yiMiaoDao;
    private BotManager botManager;
    @Autowired
    public MyTask(RunTimeAddSchedule runTimeAddSchedule) {
        this.runTimeAddSchedule = runTimeAddSchedule;
    }

    @Autowired
    public void setBotManager(BotManager botManager) {
        this.botManager = botManager;
    }
    @Autowired
    public void setYiMiaoDao(YiMiaoDao yiMiaoDao) {
        this.yiMiaoDao = yiMiaoDao;
    }

    @Autowired
    public void setHttpClientDemo(HttpClientDemo httpClientDemo) {
        this.httpClientDemo = httpClientDemo;
    }

    @Scheduled(cron = "0 0 7,9,11,13,15,17,19,21 * * ?")
    private void selectYiMiao() {
        try {
            List<YiMiao> yiMiaosHttp = JSONObject.parseObject(httpClientDemo.getLocation()).getJSONObject("data").getJSONObject("website").getJSONArray("place").toJavaList(YiMiao.class);
            List<YiMiao> yiMiaosDB = yiMiaoDao.selectList(null);
            YiMiaoUtils.yiMiaoDeleteByTimeForDB(yiMiaosDB);
            YiMiaoUtils.yiMiaoDeleteByTimeForHttp(yiMiaosHttp);
            yiMiaosHttp.removeAll(yiMiaosDB);
            if (!yiMiaosHttp.isEmpty()){
                for (YiMiao yiMiao : yiMiaosHttp){
                    botManager.getDefaultBot().getSender().SENDER.sendGroupMsg(419663585,"新增疫苗:\n"+yiMiao.toString());
                    YiMiaoListen.setRunTimeAddSchedule(yiMiao, yiMiaoDao, runTimeAddSchedule);
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
            botManager.getDefaultBot().getSender().SENDER.sendPrivateMsg("979986531",e.getMessage());
        }
    }
}
