package simbot.example.task;

import lombok.extern.slf4j.Slf4j;
import love.forte.simbot.bot.BotManager;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.stereotype.Component;
import simbot.example.domain.YiMiao;

import java.util.Date;
@Slf4j
@Component
public class RunTimeAddSchedule implements SchedulingConfigurer {
    private final ThreadPoolTaskScheduler mScheduler = new ThreadPoolTaskScheduler(); //可以动态往里面添加定时任务
    private final BotManager botManager;
    @Autowired
    public RunTimeAddSchedule(BotManager botManager) {
        this.botManager = botManager;
    }

    @Override
    public void configureTasks(@NotNull ScheduledTaskRegistrar taskRegistrar) {
        mScheduler.initialize();
    }

    public void setScheduler(Date date,YiMiao yiMiao) {

        Runnable run = new Runnable() {
            private YiMiao yiMiao;
            public Runnable setYiMiao(YiMiao yiMiao) {
                this.yiMiao = yiMiao;
                return this;
            }

            @Override
            public void run() {
                botManager.getDefaultBot().getSender().SENDER.sendGroupMsg(419663585,"即将开始"+yiMiao.toString());
            }

        }.setYiMiao(yiMiao);

        mScheduler.schedule(run,date);
        log.info("增加定时任务:\ntime:"+date+"\n对象:"+yiMiao.toString());
    }
}