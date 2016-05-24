package ru.nsu.ccfit.dymova.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by nastya on 16.05.16.
 */
@Controller
@RequestMapping("/")
public class HomePageController {
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView readTradingPlaceFeatures(){
        return new ModelAndView("index");
    }
}
