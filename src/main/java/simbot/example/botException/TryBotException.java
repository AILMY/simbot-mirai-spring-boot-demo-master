package simbot.example.botException;

import lombok.extern.slf4j.Slf4j;
import love.forte.simbot.exception.ExceptionHandle;
import love.forte.simbot.exception.ExceptionHandleContext;
import love.forte.simbot.listener.ListenResult;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
@Slf4j
@Component
public class TryBotException extends Throwable implements ExceptionHandle<TryBotException> {

//    private final BotManager botManager;
//    @Autowired
//    public TryBotException(BotManager botManager) {
//        this.botManager = botManager;
//    }

    @NotNull
    @Override
    public ListenResult<?> doHandle(@NotNull ExceptionHandleContext<TryBotException> context) {

//        botManager.getDefaultBot().getSender().SENDER.sendPrivateMsg(979986531,"异常信息:\n"+context);
       log.info(context.toString());
        return null;
    }
    /**
     * 异常处理函数。对异常进行处理并得到一个监听函数的返回值。
     *
     * @return 监听执行相应。
     */



}
