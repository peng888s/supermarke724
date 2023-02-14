package com.supermarke.ssm.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    /**
     *  转为 java.util.Date(2021-12-21 23:59:59)
     */
    public static Date stringToDate(String s){
        String str = s+" 23:59:59";
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;

        try {
            date = format.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

}
