package com.pillar.ratecalculator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

/**
 * Created by Travis Brindley on 9/7/2017.
 */
public class RateCalculator {
    public Date convertToDate(String inputdate){

        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd hh:mm:ss z yyyy");
        Date newDate = null;
        try {
            newDate = dateFormat.parse(inputdate);
            return newDate;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return newDate;
    }
    public Date addHourToDateStamp(Date userDate, int hours){
        Calendar cal = new GregorianCalendar();
        cal.setTime(userDate);
        cal.add(Calendar.HOUR, hours);
        userDate = cal.getTime();

        return userDate;
    }
    public int timeStampDifference(Date startDate, Date endDate){
        long diff = endDate.getTime() - startDate.getTime();
        return (int) TimeUnit.HOURS.convert(diff,TimeUnit.MILLISECONDS);
    }
}
