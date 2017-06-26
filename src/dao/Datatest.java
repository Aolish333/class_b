package dao;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by hp on 2017/6/24.
 */
public class Datatest {
    public static void main(String[] args) {
//        Long begin_time= Long.valueOf("2017-06-24 16:42:34");
        Date date = new Date();
        Date beginTime = new Date();
//        beginTime.setTime(begin_time);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = sdf.format(date);
        System.out.println("Current Date:"+strDate);
        System.out.println("Beginning Date:"+strDate);

    }
}
