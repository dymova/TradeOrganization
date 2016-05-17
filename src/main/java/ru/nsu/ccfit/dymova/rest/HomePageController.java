package ru.nsu.ccfit.dymova.rest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.nsu.ccfit.dymova.entities.TradingPlace;
import ru.nsu.ccfit.dymova.entities.TradingPlaceType;

import java.util.Arrays;

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
