package ru.nsu.ccfit.dymova.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



@Controller
@RequestMapping("/services")
public class ServicesController {
    @RequestMapping(method = RequestMethod.GET)
    public String getServicesPage(Model model){
        return "services/services";
    }


//    "Получить перечень и общее число поставщиков, поставляющих указанный вид товара, либо некоторый товар в объеме," +
//            " не менее заданного за весь период сотрудничества, либо за указанный период."
//    @RequestMapping(method = RequestMethod.GET, value = "/1")
//    public String getProvidersServicePage(){
//        return "entity/providers/";
//    }


}
