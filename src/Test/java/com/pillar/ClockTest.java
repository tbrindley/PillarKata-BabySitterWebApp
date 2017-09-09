package com.pillar;

import com.pillar.ratecalculator.RateCalculator;
import org.junit.Test;
import java.text.SimpleDateFormat;
import java.util.Arrays;
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
        String actual = dateFormat.format(testRate.convertToDate("2017-09-09"));
        assertEquals("Failed, Timestamps don't match!", expected, actual);
    }

    //test to ensure start hour is added to timestamp
    @Test
    public void addHoursToTimeStampTest(){
        RateCalculator testRate = new RateCalculator();

        Date tempDate = testRate.convertToDate("2017-09-09");
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

        Date tempDate = testRate.convertToDate("2017-09-09");

        Date startDate = testRate.addHourToDateStamp(tempDate,15);
        Date endDate = testRate.addHourToDateStamp(startDate,4);

        int expected = 4;
        int actual = testRate.timeStampDifference(startDate,endDate);
        assertEquals("Failed, Time difference doesn't match!", expected, actual);
    }

    //get base salary
    @Test
    public void getBaseSalaryTest(){
        RateCalculator testRate = new RateCalculator();

        Date tempDate = testRate.convertToDate("2017-09-09");

        Date startDate = testRate.addHourToDateStamp(tempDate,15);
        Date endDate = testRate.addHourToDateStamp(startDate,5);

        int expected = 60;
        int actual = testRate.calculateBaseRate(startDate,endDate);
        assertEquals("Failed, Salary doesn't match!", expected, actual);
    }

    //get different pay rates from bedtime to midnight
    @Test
    public void getPostBedTimeSalaryTest(){
        RateCalculator testRate = new RateCalculator();

        Date tempDate = testRate.convertToDate("2017-09-09");

        Date startDate = testRate.addHourToDateStamp(tempDate,15);
        Date bedTime = testRate.addHourToDateStamp(startDate,4);
        Date endDate = testRate.addHourToDateStamp(startDate,9);

        int expected = 40; //5 hours after bed @ $8hr = $40
        int actual = testRate.calculatePostBedRate(bedTime,endDate);
        assertEquals("Failed, Salary doesn't match!", expected, actual);
    }
    //Gets different rate from midnight to close;
    @Test
    public void getpostMidnightRateTest(){
        RateCalculator testRate = new RateCalculator();

        Date midnightDate = testRate.convertToDate("2017-09-09");
        Date endDate = testRate.addHourToDateStamp(midnightDate,2);

        int expected = 32; //2 hours after bed @ $16hr = $40
        int actual = testRate.calculateMidnightRate(midnightDate,endDate);
        assertEquals("Failed, Salary doesn't match!", expected, actual);
    }

    //Calculate nightly salary for someone who worked past midnight
    @Test
    public void getNightSalaryTest1(){
        RateCalculator testRate = new RateCalculator();
        Date tempDate = testRate.convertToDate("2017-09-09");

        Date startDate = testRate.addHourToDateStamp(tempDate,17); //5pm start
        Date bedTime = testRate.addHourToDateStamp(startDate,2);  //7pm bedtime
        Date midnight = testRate.addHourToDateStamp(tempDate,24); //Sets midnight
        Date endDate = testRate.addHourToDateStamp(startDate,8); //1am end Time

        int expected = 80; //2hrs @ 12, 5 hrs @ $8, 1 hr @ 16;
        int actual = testRate.calculateNightlyWage(startDate,bedTime,midnight,endDate);
        assertEquals("Failed, Salary doesn't match!", expected, actual);
    }
    //Calculate nightly salary when someone does NOT work past mightnight
    @Test
    public void getNightSalaryTest2(){
        RateCalculator testRate = new RateCalculator();
        Date tempDate = testRate.convertToDate("2017-09-09");

        Date startDate = testRate.addHourToDateStamp(tempDate,17); //5pm start
        Date bedTime = testRate.addHourToDateStamp(startDate,2);  //7pm bedtime
        Date midnight = testRate.addHourToDateStamp(tempDate,24); //Sets midnight
        Date endDate = testRate.addHourToDateStamp(startDate,6); //11pm end Time

        int expected = 56; //2hrs @ 12, 4 hrs @ $8;
        int actual = testRate.calculateNightlyWage(startDate,bedTime,midnight,endDate);
        assertEquals("Failed, Salary doesn't match!", expected, actual);
    }
    //Calculate nightly salary when someone does NOT work past bedtime
    @Test
    public void getNightSalaryTest3(){
        RateCalculator testRate = new RateCalculator();
        Date tempDate = testRate.convertToDate("2017-09-09");

        Date startDate = testRate.addHourToDateStamp(tempDate,17); //5pm start
        Date bedTime = testRate.addHourToDateStamp(startDate,2);  //7pm bedtime
        Date midnight = testRate.addHourToDateStamp(tempDate,24); //Sets midnight
        Date endDate = testRate.addHourToDateStamp(startDate,1); //6pm end Time

        int expected = 12; //1hrs @ 12;
        int actual = testRate.calculateNightlyWage(startDate,bedTime,midnight,endDate);
        assertEquals("Failed, Salary doesn't match!", expected, actual);
    }
    //returns arraylist of category values;
    @Test
    public void getCategoryValuesTest(){
        RateCalculator testRate = new RateCalculator();
        Date tempDate = testRate.convertToDate("2017-09-09");

        Date startDate = testRate.addHourToDateStamp(tempDate,17); //5pm start
        Date bedTime = testRate.addHourToDateStamp(startDate,2);  //7pm bedtime
        Date midnight = testRate.addHourToDateStamp(tempDate,24); //Sets midnight
        Date endDate = testRate.addHourToDateStamp(midnight,1); //1am end Time

        int[] testArray = {24,40,16};//2hrs @ $12, 5hrs @ $8, 1hr @ $16;
        String expected = Arrays.toString(testArray);
        String actual = Arrays.toString(testRate.returnCategoryTotals(startDate,bedTime,midnight,endDate));
        assertEquals("Failed, Arrays don't match!", expected, actual);
    }
}
