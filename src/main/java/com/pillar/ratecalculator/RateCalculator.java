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

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
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
        int postMidnightSalary = 0;
        int baseSalary = 0;
        int postBedSalary = 0;
        if(startDate.before(bedtime) & endTime.after(bedtime)){ //only calculates higher "basepay" if child is awake at for 1 hour min.
            baseSalary = calculateBaseRate(startDate,bedtime);
        }
        else if(startDate.before(bedtime) & endTime.before(bedtime)){
            baseSalary = calculateBaseRate(startDate,endTime);
        }

        //determines if endtime is before or after midnight and pays out accordingly
        if(bedtime.before(endTime) & endTime.before(mightnight)){
            postBedSalary = calculatePostBedRate(bedtime,endTime);
        }
        else if(bedtime.before(endTime) & endTime.after(mightnight)){
            postBedSalary = calculatePostBedRate(bedtime,mightnight);
        }

        if(endTime.after(mightnight)){
            postMidnightSalary = calculateMidnightRate(mightnight,endTime);
        }

        return baseSalary + postBedSalary + postMidnightSalary;
    }
}
