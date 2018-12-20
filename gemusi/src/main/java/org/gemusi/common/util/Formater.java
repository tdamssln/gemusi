package org.gemusi.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Formater {

    public static String Calendar2String(Calendar calendar) {
        if (null == calendar) {
            return null;
        }
        return Date2String(calendar.getTime());
    }

    public static String Calendar2String(Calendar calendar, String format) {
        if (null == calendar) {
            return null;
        }
        return Date2String(calendar.getTime(), format);
    }

    public static Calendar Date2Calendar(Date date) {
        Calendar result = Calendar.getInstance();
        result.clear();
        if (null != date) {
            result.setTime(date);
        }
        return result;
    }

    public static String Date2String(Date date) {
        if (null == date) {
            return null;
        }
        String format = "yyyy-MM-dd";
        return Date2String(date, format);
    }

    public static String Date2String(Date date, String format) {
        if (null == date) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    /**
     *
     * @param path
     * @return
     */
    public static String formatPath(String path) {
        if (null == path || "".equals(path.trim())) {
            return "";
        }

        char lastChar = path.charAt(path.length() - 1);
        if (lastChar == '\\' || lastChar == '/') {
            return path;
        } else {
            return path + System.getProperty("file.separator");
        }
    }


    public static void main(String[] args) throws ParseException {
        //DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //String ceshi = "2010-08-05 14:42:25:000";
        //Calendar calendar = Calendar.getInstance();
        //Date date = format.parse(ceshi);
        //calendar.setTime(date);
        //System.out.println(calendar.getTime());

        Calendar calendar = Calendar.getInstance();
        System.out.println(Calendar2String(calendar,"yyyy-MM-dd"));
    }
}
