package simbot.example.test;

public class Demo  {
//    private BotManager botManager;
//    @Autowired
//    public Demo(BotManager botManager) {
//        this.botManager = botManager;
//    }
//
//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//
//        botManager.getDefaultBot().getSender().SENDER.sendPrivateMsg(979986531,"run");
//    }
//    public static void main(String[] args) {
//        String str="{\"state\":1,\"message\":\"success\",\"data\":{\"xiaoxi\":[{\"id\":\"7\",\"cityname\":\"\\u6210\\u90fd\",\"title\":\"2022\\u6210\\u90fd\\u4e5d\\u4ef7HPV\\u75ab\\u82d7\\u6253\\u9488\\u6700\\u65b0\\u6d88\\u606f\\uff08\\u6301\\u7eed\\u66f4\\u65b0\\uff09\",\"url\":\"http:\\/\\/m.cd.bendibao.com\\/live\\/100608.shtm\",\"orderid\":\"0\",\"citycode\":\"cd\",\"url_arr\":{\"id\":\"100608\",\"type\":\"article\",\"url\":\"http:\\/\\/m.cd.bendibao.com\\/live\\/100608.shtm\"}}],\"website\":{\"place\":[{\"id\":\"1300\",\"cityname\":\"\\u6210\\u90fd\",\"name\":\"\\u6210\\u90fd\\u5e02\\u9f99\\u6cc9\\u9a7f\\u533a\\u5987\\u5e7c\\u4fdd\\u5065\\u9662\",\"addr\":\"\\u6210\\u90fd\\u5e02\\u9f99\\u6cc9\\u9a7f\\u533a\\u5987\\u5e7c\\u4fdd\\u5065\\u9662\\u4e00\\u697c\\u9884\\u9632\\u63a5\\u79cd\\u95e8\\u8bca\",\"minge\":\"325\\u4eba\\u4efd\",\"condition\":\"\",\"tel\":\"028-69330819(\\u5de5\\u4f5c\\u65f6\\u95f4)\",\"method\":\"\\u7f51\\u4e0a\\u9884\\u7ea6\",\"orderid\":\"3\",\"jd\":\"104.277863\",\"wd\":\"30.586446\",\"platform\":\"\\u79d2\\u82d7\\u5c0f\\u7a0b\\u5e8f\",\"yy_time\":\"2022-02-14 14:00:00\",\"url\":\"http:\\/\\/imgbdb3.bendibao.com\\/cdbdb\\/live\\/20221\\/21\\/2022121135954_51110.png\",\"course\":\"http:\\/\\/cd.bendibao.com\\/live\\/20181211\\/101276.shtm\",\"citycode\":\"cd\",\"url_arr\":{\"id\":0,\"type\":\"\",\"url\":\"http:\\/\\/imgbdb3.bendibao.com\\/cdbdb\\/live\\/20221\\/21\\/2022121135954_51110.png\"},\"course_arr\":{\"id\":\"101276\",\"type\":\"article\",\"citycode\":\"cd\",\"url\":\"http:\\/\\/cd.bendibao.com\\/live\\/20181211\\/101276.shtm\"}},{\"id\":\"1293\",\"cityname\":\"\\u6210\\u90fd\",\"name\":\"\\u6210\\u90fd\\u9ad8\\u65b0\\u533a\\u65b0\\u5317\\u793e\\u533a\\u536b\\u751f\\u670d\\u52a1\\u4e2d\\u5fc3\",\"addr\":\"\\u6210\\u90fd\\u9ad8\\u65b0\\u533a\\u65b0\\u5317\\u793e\\u533a\\u536b\\u751f\\u670d\\u52a1\\u4e2d\\u5fc3  \",\"minge\":\"32\\u4eba\\u4efd\",\"condition\":\"\",\"tel\":\"\",\"method\":\"\\u7f51\\u4e0a\\u9884\\u7ea6\",\"orderid\":\"2\",\"jd\":\"104.046664\",\"wd\":\"30.615104\",\"platform\":\"\\u79d2\\u82d7\",\"yy_time\":\"2022-02-14 09:00:00\",\"url\":\"http:\\/\\/imgbdb3.bendibao.com\\/cdbdb\\/live\\/20221\\/21\\/2022121135954_51110.png\",\"course\":\"http:\\/\\/cd.bendibao.com\\/live\\/20181211\\/101276.shtm\",\"citycode\":\"cd\",\"url_arr\":{\"id\":0,\"type\":\"\",\"url\":\"http:\\/\\/imgbdb3.bendibao.com\\/cdbdb\\/live\\/20221\\/21\\/2022121135954_51110.png\"},\"course_arr\":{\"id\":\"101276\",\"type\":\"article\",\"citycode\":\"cd\",\"url\":\"http:\\/\\/cd.bendibao.com\\/live\\/20181211\\/101276.shtm\"}},{\"id\":\"1292\",\"cityname\":\"\\u6210\\u90fd\",\"name\":\"\\u6210\\u534e\\u533a\\u4e07\\u5e74\\u793e\\u533a\\u536b\\u751f\\u670d\\u52a1\\u4e2d\\u5fc3\",\"addr\":\"\\u69d0\\u6811\\u5e97\\u8def\\u957f\\u878d\\u885729\\u53f7\",\"minge\":\"50\\u4eba\\u4efd\",\"condition\":\"\",\"tel\":\"028-84085587\",\"method\":\"\\u7f51\\u4e0a\\u9884\\u7ea6\",\"orderid\":\"1\",\"jd\":\"104.149498\",\"wd\":\"30.659869\",\"platform\":\"\\u77e5\\u82d7\\u6613\\u7ea6\",\"yy_time\":\"2022-02-14 09:00:00\",\"url\":\"http:\\/\\/imgbdb3.bendibao.com\\/cdbdb\\/live\\/202110\\/18\\/20211018114433_37691.png\",\"course\":\"http:\\/\\/cd.bendibao.com\\/live\\/202199\\/128756.shtm\",\"citycode\":\"cd\",\"url_arr\":{\"id\":0,\"type\":\"\",\"url\":\"http:\\/\\/imgbdb3.bendibao.com\\/cdbdb\\/live\\/202110\\/18\\/20211018114433_37691.png\"},\"course_arr\":{\"id\":\"128756\",\"type\":\"article\",\"citycode\":\"cd\",\"url\":\"http:\\/\\/cd.bendibao.com\\/live\\/202199\\/128756.shtm\"}}]},\"calldata\":{\"place\":[]},\"onsitedate\":{\"place\":[]},\"title\":\"\\u4e5d\\u4ef7\\u75ab\\u82d7\\u6700\\u65b0\\u6d88\\u606f_\\u4e5d\\u4ef7\\u5bab\\u9888\\u764c\\u75ab\\u82d7\\u9884\\u7ea6\\u5165\\u53e3|\\u8d39\\u7528|\\u79d2\\u6740\\u653b\\u7565-\\u6210\\u90fd\\u672c\\u5730\\u5b9d\",\"desc\":\"\\u6210\\u90fd\\u672c\\u5730\\u5b9d\\u63d0\\u4f9b\\u4e5d\\u4ef7\\u5bab\\u9888\\u764c\\u75ab\\u82d7\\u9884\\u7ea6\\u5165\\u53e3|\\u8d39\\u7528|\\u79d2\\u6740\\u653b\\u7565\\u65b9\\u9762\\u4fe1\\u606f\\u3002\",\"daofen\":false}}";
////        String s = StringUtil.decodeUnicode(str);
////        log.info(s);
//        JSONArray entity = JSONObject.parseObject(str).getJSONObject("data").getJSONObject("website").getJSONArray("place");
//        List<YiMiao> yiMiao = entity.toJavaList(YiMiao.class);
//        System.out.println(yiMiao);

//        for (int i=0;i<100;i++){
//            a=a++;
//        }
//        List<String> http = new LinkedList<>();
//            http.add("a");http.add("b");

//        List<String> db = new LinkedList<>();
//            db.add("a");
//        System.out.println(http.removeAll(db));

//    }
}
