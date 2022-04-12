package simbot.example.init;

import love.forte.simbot.bot.BotManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import simbot.example.dao.YiMiaoDao;
import simbot.example.domain.YiMiao;
import simbot.example.listener.YiMiaoListen;
import simbot.example.task.RunTimeAddSchedule;
import simbot.example.utils.YiMiaoUtils;

import java.util.ArrayList;
import java.util.List;

@Component
public class YimiaoSetScheduleInit implements ApplicationRunner {
    private BotManager botManager;
    private YiMiaoDao yiMiaoDao;
    private RunTimeAddSchedule runTimeAddSchedule;
    @Autowired
    public YimiaoSetScheduleInit(BotManager botManager, YiMiaoDao yiMiaoDao, RunTimeAddSchedule runTimeAddSchedule) {
        this.botManager = botManager;
        this.yiMiaoDao = yiMiaoDao;
        this.runTimeAddSchedule = runTimeAddSchedule;
    }
    @Override
    public void run(ApplicationArguments args) throws Exception {
        botManager.getDefaultBot().getSender().SENDER.sendGroupMsg(419663585,"我活了");
        List<YiMiao> yiMiaosDB = yiMiaoDao.selectList(null);
        YiMiaoUtils.yiMiaoDeleteByTimeForDB(yiMiaosDB);
        List<String> list = new ArrayList<>();
        for (YiMiao yiMiao:yiMiaosDB){
            YiMiaoListen.setRunTimeAddSchedule(yiMiao, yiMiaoDao, runTimeAddSchedule);
            list.add(yiMiao.getName());
        }
        botManager.getDefaultBot().getSender().SENDER.sendGroupMsg(419663585,"定时任务已添加"+list.size()+"个:\n"+list);

    }
}
