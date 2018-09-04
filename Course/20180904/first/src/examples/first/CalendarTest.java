package examples.first;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalendarTest {
    public static void main(String args[]) {
        // Calendar calendar = new Calendar();
        // 자동차 c = new 자동차(); (X)
        // 자동차 c = new 버스(); (O)
        Calendar cal1 = new GregorianCalendar();

        Calendar cal2 = Calendar.getInstance();

        System.out.println(Calendar.AM);
        System.out.println(Calendar.MONTH);

        System.out.println(cal2.get(Calendar.YEAR));
        System.out.println(cal2.get(Calendar.MONTH)); // 8
        System.out.println(cal2.get(Calendar.DAY_OF_MONTH));
    }
}

