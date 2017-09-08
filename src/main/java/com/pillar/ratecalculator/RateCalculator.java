package com.pillar.ratecalculator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
}
