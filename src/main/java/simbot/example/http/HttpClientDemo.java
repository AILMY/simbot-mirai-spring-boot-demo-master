package simbot.example.http;

import com.dtflys.forest.annotation.Get;
import org.springframework.stereotype.Component;

@Component
public interface HttpClientDemo {
    @Get("https://wxapidg.bendibao.com/smartprogram/zhuanti.php?platform=wx&version=21.11.08&action=jiujia&citycode=cd")
    String getLocation();
}
