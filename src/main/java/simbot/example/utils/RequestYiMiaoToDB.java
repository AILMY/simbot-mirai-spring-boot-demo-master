package simbot.example.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import simbot.example.dao.YiMiaoDao;
import simbot.example.domain.YiMiao;

import java.util.List;

@Component
public class RequestYiMiaoToDB {
    private YiMiaoDao yiMiaoDao;
    @Autowired
    public void setYiMiaoDao(YiMiaoDao yiMiaoDao) {
        this.yiMiaoDao = yiMiaoDao;
    }
    public List<YiMiao> getAll(){
        return yiMiaoDao.selectList(null);
    }
    public int addOne(YiMiao yiMiao){
        return yiMiaoDao.insert(yiMiao);
    }
}
