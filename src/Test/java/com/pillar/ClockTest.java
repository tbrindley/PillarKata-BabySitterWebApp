package com.pillar;

import com.pillar.ratecalculator.RateCalculator;
import org.junit.Test;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * Created by Travis Brindley on 9/7/2017.
 */
public class ClockTest {
    @Test
    public void timeStampCreationTest() throws Exception {

        RateCalculator testRate = new RateCalculator(); //Create test instance for rateCalculator object
        Date newDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

        //convert dates to Strings to remove seconds from Date
        String expected = dateFormat.format(newDate);
        String actual = dateFormat.format(testRate.convertToDate("Thu Sep 07 00:00:00 EDT 2017"));
        assertEquals("Failed, Timestamps don't match!", expected, actual);
    }
}
