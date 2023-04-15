package utilities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtils {

    public static String[] returnNextMonth(){

        Date dnow = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(dnow);

        SimpleDateFormat sdf = new SimpleDateFormat("MMM=yyyy");
        calendar.add(Calendar.MONTH, 4);
        String date = sdf.format(calendar.getTime());

        return date.split("-");
    }

}
