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

    public int calculateBaseRate(Date startDate, Date endDate){
        int hoursWorked = timeStampDifference(startDate,endDate);

        return hoursWorked * 12;
    }

    public int calculatePostBedRate(Date bedtime, Date endDate){
        int postBedHours = timeStampDifference(bedtime,endDate);

        return postBedHours * 8;
    }

    public int calculateMidnightRate(Date midnight, Date endDate){
        int postMidnightHours = timeStampDifference(midnight,endDate);

        return postMidnightHours * 16;
    }

    public int calculateNightlyWage(Date startDate, Date bedtime, Date mightnight, Date endTime){
        int baseSalary = calculateBaseRate(startDate,bedtime);
        int postBedSalary = calculatePostBedRate(bedtime,mightnight);
        int postMidnightSalary = calculateMidnightRate(mightnight,endTime);
        return baseSalary + postBedSalary + postMidnightSalary;
    }
}
