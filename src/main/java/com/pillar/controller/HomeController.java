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

        //Date methods
        Date tempDate = testRate.convertToDate(startString);
        Date startDate = testRate.addHourToDateStamp(tempDate, startTime);
        Date bedTime = testRate.addHourToDateStamp(tempDate, bedTimeInt);
        Date midnight = testRate.addHourToDateStamp(tempDate, 24);
        Date endDate = testRate.addHourToDateStamp(tempDate, endTime);

        //output formats
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        SimpleDateFormat bedFormat = new SimpleDateFormat("hh:mm a");


        int[] categorySalaries = testRate.returnCategoryTotals(startDate,bedTime,midnight,endDate);
        int salary = testRate.calculateNightlyWage(startDate, bedTime, midnight, endDate);

        //models
        model.addAttribute("startDay", dateFormat.format(startDate));
        model.addAttribute("startTime",bedFormat.format(startDate));
        model.addAttribute("bedTime", bedFormat.format(bedTime));
        model.addAttribute("endDate", dateFormat.format(endDate));
        model.addAttribute("endTime",bedFormat.format(endDate));
        model.addAttribute("baseSalary",categorySalaries[0]);
        model.addAttribute("postBedSalary",categorySalaries[1]);
        model.addAttribute("midnightSalary",categorySalaries[2]);
        model.addAttribute("totalSalary", salary);

        return "results";
    }

}
