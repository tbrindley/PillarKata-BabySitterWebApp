package com.pillar.controller;

/**
 * Created by Travis Brindley on 7/21/2017.
 */
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String homepage(){
        return "index";
    }

    @RequestMapping("getRate")
   public String getRate(Model model, @RequestParam("startDate") String startDate, @RequestParam("startTime") String startTime){

        model.addAttribute("startday", startDate);
        model.addAttribute("startTime", startTime);
        return "results";
   }

}
