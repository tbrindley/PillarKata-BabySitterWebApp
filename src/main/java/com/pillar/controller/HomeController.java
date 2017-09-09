package com.pillar.controller;

/**
 * Created by Travis Brindley on 7/21/2017.
 */

import com.pillar.ratecalculator.RateCalculator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String homepage() {
        return "index";
    }

    @RequestMapping("getRate")
    public String getRate(Model model, @RequestParam("startDate") String startString, @RequestParam("startTime") int startTime,
                          @RequestParam("bedTime") int bedTimeInt, @RequestParam("endTime") int endTime) {

        RateCalculator testRate = new RateCalculator();

        Date tempDate = testRate.convertToDate(startString);
        Date startDate = testRate.addHourToDateStamp(tempDate, startTime);
        Date bedTime = testRate.addHourToDateStamp(tempDate, bedTimeInt);
        Date midnight = testRate.addHourToDateStamp(tempDate, 24);
        Date endDate = testRate.addHourToDateStamp(tempDate, endTime);
        //output formats
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        SimpleDateFormat bedFormat = new SimpleDateFormat("hh:mm a");

        //outputs
        String startOutput = dateFormat.format(startDate);
        String startTimeOutput = bedFormat.format(startDate);
        String bedTimeOutput = bedFormat.format(bedTime);
        String endOutput = dateFormat.format(endDate);
        int salary = testRate.calculateNightlyWage(startDate, bedTime, midnight, endDate);

        //models
        model.addAttribute("startDay", startOutput);
        model.addAttribute("startTime",startTimeOutput);
        model.addAttribute("bedTime", bedTimeOutput);
        model.addAttribute("endDate", endOutput);
        model.addAttribute("salary", salary);

        return "results";
    }

}
