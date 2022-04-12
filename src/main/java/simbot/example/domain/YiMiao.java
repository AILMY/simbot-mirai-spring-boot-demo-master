package simbot.example.domain;

import lombok.Data;
@Data
public class YiMiao {
    private String cityname;
    private String name;
    private String minge;
    private String yyTime;
    private String platform;

    @Override
    public String toString() {
        return cityname +"\n"+ name +"\n"+ minge +"\n"+ yyTime +"\n"+ platform ;
    }
}
