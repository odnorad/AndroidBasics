package at.technikumwien.birthdaynotifier.ui.main;

import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by nicoleang on 24.04.17.
 */

public class Utils {

    private static final SimpleDateFormat BIRTHDAY_FORMAT = new SimpleDateFormat("dd. MMM\nyyyy");
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-mm-dd");

    public static boolean isToday(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        Calendar now = Calendar.getInstance();

        return now.get(Calendar.MONTH) == calendar.get(Calendar.MONTH) &&
                now.get(Calendar.DAY_OF_MONTH) == calendar.get(Calendar.DAY_OF_MONTH);
    }

    public static Date parseDate(String dateString){
        try {
            return DATE_FORMAT.parse(dateString);
        }catch (ParseException e){
            Log.e("Utils","Could not parse String '" + dateString + "' with date format '" + DATE_FORMAT.toPattern() + "'");
            return null;
        }
    }

    public static String formatBirthday(Date birtday){
        return BIRTHDAY_FORMAT.format(birtday);
    }
}
