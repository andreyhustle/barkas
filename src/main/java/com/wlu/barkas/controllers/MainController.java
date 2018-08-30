package com.wlu.barkas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Controller
public class MainController {
    @RequestMapping("/welcome.html")
    public ModelAndView greetings(){
        Date dateAndTime = new Date();
        return new ModelAndView("welcome", "dateAndTime", dateAndTime);
    }
}
