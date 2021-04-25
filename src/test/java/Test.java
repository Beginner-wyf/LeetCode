import java.util.Calendar;
import java.util.Date;

/**
 * @author wangyifan
 * @create 2021/4/15 15:46
 */
public class Test {
    @org.junit.Test
    public void test1(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);
        //获取今日的00:00:00
        Date start = calendar.getTime();
        //加一天
        calendar.set(Calendar.HOUR_OF_DAY,24);
        //获取今天结束时间
        Date end = calendar.getTime();
        System.out.println("start:"+start);
        System.out.println("end:"+end);
    }
}
