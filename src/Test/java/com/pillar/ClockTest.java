package com.pillar;

import com.pillar.ratecalculator.RateCalculator;
import org.junit.Test;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

/**
 * Created by Travis Brindley on 9/7/2017.
 */
public class ClockTest {
    //tests to ensure a date timestamp was created
    @Test
    public void timeStampCreationTest() throws Exception {

        RateCalculator testRate = new RateCalculator(); //Create test instance for rateCalculator object
        Date newDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

        //convert dates to Strings to remove seconds from Date
        String expected = dateFormat.format(newDate);
        String actual = dateFormat.format(testRate.convertToDate("Thu Sep 08 00:00:00 EDT 2017"));
        assertEquals("Failed, Timestamps don't match!", expected, actual);
    }

    //test to ensure start hour is added to timestamp
    @Test
    public void addHoursToTimeStampTest(){
        RateCalculator testRate = new RateCalculator();

        Date tempDate = testRate.convertToDate("Thu Sep 08 00:00:00 EDT 2017");
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH");

        //convert dates to Strings to remove seconds from Date
        String expected = "09/08/2017 15";
        String actual = dateFormat.format(testRate.addHourToDateStamp(tempDate,15));
        assertEquals("Failed, Timestamps don't match!", expected, actual);
    }

    //Get the difference between start time & end time
    @Test
    public void getDifferenceBetweenStartTimeStampAndEndTimeStamp(){
        RateCalculator testRate = new RateCalculator();

        Date tempDate = testRate.convertToDate("Thu Sep 08 00:00:00 EDT 2017");

        Date startDate = testRate.addHourToDateStamp(tempDate,15);
        Date endDate = testRate.addHourToDateStamp(startDate,4);

        int expected = 4;
        int actual = testRate.timeStampDifference(startDate,endDate);
        assertEquals("Failed, Time difference doesn't match!", expected, actual);
    }
}
