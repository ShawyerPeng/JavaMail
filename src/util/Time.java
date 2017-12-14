package util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Time {
    public static String getDate(){
        Date date = new Date();
        DateFormat f= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = f.format(date);
        return time;
    }

}
