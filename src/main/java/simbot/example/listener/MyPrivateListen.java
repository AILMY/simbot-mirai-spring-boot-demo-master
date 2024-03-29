package simbot.example.listener;

import catcode.CatCodeUtil;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import love.forte.common.ioc.annotation.Beans;
import love.forte.simbot.annotation.OnPrivate;
import love.forte.simbot.api.message.MessageContent;
import love.forte.simbot.api.message.MessageContentBuilder;
import love.forte.simbot.api.message.MessageContentBuilderFactory;
import love.forte.simbot.api.message.events.PrivateMsg;
import love.forte.simbot.api.sender.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import simbot.example.dao.YiMiaoDao;
import simbot.example.domain.YiMiao;
import simbot.example.http.HttpClientDemo;
import simbot.example.utils.YiMiaoUtils;

import java.text.ParseException;
import java.util.List;

/**
 * 私聊消息监听的示例类。
 * 所有需要被管理的类都需要标注 {@link Service} 注解。
 *
 * 由于当前是处于springboot环境下，因此强烈建议类上的注释使用：
 * <ul>
 *     <li>{@link org.springframework.stereotype.Component}</li>
 *     <li>{@link Service}</li>
 * </ul>
 * 等注解来代替simbot的 {@link Beans}。
 *
 * 同样的，依赖注入也请使用 {@link Autowired} 等Springboot相关的注解。
 *
 * @author ForteScarlet
 */
@Slf4j
@Service
public class MyPrivateListen {
    private YiMiaoDao yiMiaoDao;
    private HttpClientDemo httpClientDemo;
    @Autowired
    public void setYiMiaoDao(YiMiaoDao yiMiaoDao) {
        this.yiMiaoDao = yiMiaoDao;
    }
    @Autowired
    public void setHttpClientDemo(HttpClientDemo httpClientDemo) {
        this.httpClientDemo = httpClientDemo;
    }

    /**
     * 通过依赖注入获取一个 "消息正文构建器工厂"。
     *
     */

    private final MessageContentBuilderFactory messageContentBuilderFactory;
    @Autowired
    public MyPrivateListen(MessageContentBuilderFactory messageContentBuilderFactory) {
        this.messageContentBuilderFactory = messageContentBuilderFactory;
    }

    /**
     * 此监听函数监听一个私聊消息，并会复读这个消息，然后再发送一个表情。
     * 此方法上使用的是一个模板注解{@link OnPrivate}，
     * 其代表监听私聊。
     * 由于你监听的是私聊消息，因此参数中要有个 {@link PrivateMsg} 来接收这个消息实体。
     *
     * 其次，由于你要“复读”这句话，因此你需要发送消息，
     * 因此参数中你需要一个 "消息发送器" {@link Sender}。
     *
     * 当然，你也可以使用 {@link love.forte.simbot.api.sender.MsgSender}，
     * 然后 {@code msgSender.SENDER}.
     */
//    @OnPrivate
//    @Filter("test")
    public void test(PrivateMsg privateMsg,Sender sender){
        List<YiMiao> yiMiaosHttp = JSONObject.parseObject(httpClientDemo.getLocation()).getJSONObject("data").getJSONObject("website").getJSONArray("place").toJavaList(YiMiao.class);
        List<YiMiao> yiMiaosDB = yiMiaoDao.selectList(null);
        try {
            YiMiaoUtils.yiMiaoDeleteByTimeForDB(yiMiaosDB);
            YiMiaoUtils.yiMiaoDeleteByTimeForHttp(yiMiaosHttp);
        } catch (ParseException e) {
            e.printStackTrace();
            sender.sendPrivateMsg(privateMsg,e.getMessage());
        }
        for (YiMiao yiMiao:yiMiaosDB){
            sender.sendPrivateMsg(privateMsg,yiMiao.toString());
        }
        yiMiaosHttp.removeAll(yiMiaosDB);
        if (!yiMiaosHttp.isEmpty()){
            for (YiMiao yiMiao : yiMiaosHttp){
                sender.sendPrivateMsg(privateMsg,"新增疫苗:\n"+yiMiao.toString());
                yiMiaoDao.insert(yiMiao);
            }
        }
    }

    public void replyPrivateMsg1(PrivateMsg privateMsg, Sender sender){
        // 获取消息正文。
        MessageContent msgContent = privateMsg.getMsgContent();
        // Generated by ApiPost: https://www.apipost.cn/

//        Request request = Request.Get("https://cloud.cn2030.com/sc/wx/HandlerSubscribe.ashx?act=CustomerList&city=%5B%22%E5%9B%9B%E5%B7%9D%E7%9C%81%22%2C%22%E6%88%90%E9%83%BD%E5%B8%82%22%2C%22%22%5D&lat=27.72545&lng=106.92723&id=0&cityCode=510100&product=1");
//        HttpResponse httpResponse = request.execute().returnResponse();
//        System.out.println(httpResponse.getStatusLine());
//        request.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.143 Safari/537.36 MicroMessenger/7.0.9.501 NetType/WIFI MiniProgramEnv/Windows WindowsWechat");
//        request.setHeader("Host", "cloud.cn2030.com");
//        request.setHeader("Connection", "keep-alive");
//        request.setHeader("Cookie", "");
//        request.setHeader("Content-Type", "application/json");
//        request.setHeader("Zftsl", "382dbd4899824e7863cc3f23b65e2d3d");
//        request.setHeader("Referer", "https://servicewechat.com/wx2c7f0f3c30d99445/90/page-frame.html");
//        request.setHeader("Accept-Encoding", "gzip, deflate, br");
//        HttpResponse httpResponse = request.execute().returnResponse();
//        System.out.println(httpResponse.getStatusLine());
//        if (httpResponse.getEntity() != null) {
//            String html = EntityUtils.toString(httpResponse.getEntity());
//            System.out.println(html);
//        }

        // 向 privateMsg 的账号发送消息，消息为当前接收到的消息。
        sender.sendPrivateMsg(privateMsg, msgContent);

        // 再发送一个表情ID为'9'的表情。
        // 方法1：使用消息构建器构建消息并发送
        // 在绝大多数情况下，使用消息构建器所构建的消息正文 'MessageContent'
        // 是用来发送消息最高效的选择。
        // 相对的，MessageContentBuilder所提供的构建方法是十分有限的。

        // 获取消息构建器
        MessageContentBuilder msgBuilder = messageContentBuilderFactory.getMessageContentBuilder();
        // 通过.text(...) 向builder中追加一句话。
        // 通过.face(ID) 向builder中追加一个表情。
        // 通过.build() 构建出最终消息。
        MessageContent msg = msgBuilder.text("表情：").face(9).build();

        // 直接通过这个msg发送。
        sender.sendPrivateMsg(privateMsg, msg);

        // 方法2：使用CAT码发送消息。
        // 使用CAT码构建一个需要解析的消息是最灵活的，
        // 但是相对的，它的效率并不是十分的可观，毕竟在这其中可能会涉及到很多的'解析'操作。

        // 获取CAT码工具类实例
        CatCodeUtil catCodeUtil = CatCodeUtil.getInstance();

        // 构建一个类型为 'face', 参数为 'id=9' 的CAT码。
        // 有很多方法。

        // 1. 通过 codeBuilder 构建CAT码
        // String cat1 = catCodeUtil.getStringCodeBuilder("face", false).key("id").value(9).build();

        // 2. 通过CatCodeUtil.toCat 构建CAT码
        // String cat2 = catCodeUtil.toCat("face", "id=9");

        // 3. 通过模板构建CAT码
        String cat3 = catCodeUtil.getStringTemplate().face(9);

        // 在cat码前增加一句 '表情' 并发送
        sender.sendPrivateMsg(privateMsg, "表情：" + cat3);

    }

}
