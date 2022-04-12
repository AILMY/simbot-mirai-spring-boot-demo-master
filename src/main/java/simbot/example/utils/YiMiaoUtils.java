package simbot.example.utils;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import simbot.example.dao.YiMiaoDao;
import simbot.example.domain.YiMiao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
@Component
public class YiMiaoUtils {
    @Autowired
    public void setYiMiaoDao(YiMiaoDao yiMiaoDao) {
        YiMiaoUtils.yiMiaoDao = yiMiaoDao;
    }

    static YiMiaoDao yiMiaoDao;
    public static void yiMiaoDeleteByTimeForDB(List<YiMiao> yiMiaoParse) throws ParseException {

        Iterator<YiMiao> it = yiMiaoParse.iterator();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        LambdaUpdateWrapper<YiMiao> wrapper = new LambdaUpdateWrapper<>();
        while (it.hasNext()){
            YiMiao yiMiao = it.next();
            Date date = format.parse(yiMiao.getYyTime());
            if (date.before(new Date())){
                wrapper.eq(Strings.isNotEmpty(yiMiao.getName()),YiMiao::getName,yiMiao.getName());
                yiMiaoDao.delete(wrapper);
                it.remove();
            }
        }
    }
    public static void yiMiaoDeleteByTimeForHttp(List<YiMiao> yiMiaoParse) throws ParseException {

        Iterator<YiMiao> it = yiMiaoParse.iterator();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        while (it.hasNext()){
            YiMiao yiMiao = it.next();
            Date date = format.parse(yiMiao.getYyTime());
            if (date.before(new Date())){
                it.remove();
            }
        }
    }
}
