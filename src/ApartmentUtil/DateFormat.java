package ApartmentUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormat {
    // now -> yyyy-MM-dd hh:mm:ss
    public static String nowToDateTime() {
        String strDate = null;
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        strDate = simpleDateFormat.format(date);
        return strDate;
    }
}
