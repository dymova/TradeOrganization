package ru.nsu.ccfit.dymova.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.nsu.ccfit.dymova.entities.Good;
import ru.nsu.ccfit.dymova.entities.GoodInTradingPlace;
import ru.nsu.ccfit.dymova.jpa.GoodInTradingPlaceRepository;
import ru.nsu.ccfit.dymova.jpa.TradingPlaceRepository;

import java.util.List;


@Controller
@RequestMapping("/services")
public class ServicesController {
    @Autowired
    private GoodInTradingPlaceRepository goodInTradingPlaceRepository;

    @Autowired
    private TradingPlaceRepository placeRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String getServicesPage(Model model){
        return "services/services";
    }

//    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
//    public String getServicePage(@PathVariable("id") String id){
//        return "services/" + id;
//    }


    //Получить номенклатуру и объем товаров в указанной торговой точке.
    @RequestMapping(method = RequestMethod.GET, value = "form/3")
    public String getGoodsInTradingPlace(Model model) {
        model.addAttribute("places", placeRepository.findAll());
        return "services/3";
    }
    @RequestMapping(method = RequestMethod.GET, value = "/3")
    public String getGoodsInTradingPlace(@RequestParam("tradingPlace") String tradingPlaceName, Model model){
        model.addAttribute("places", placeRepository.findAll());
        if(!tradingPlaceName.isEmpty()) {
            List<GoodInTradingPlace> goods = goodInTradingPlaceRepository.findByTradingPlace(placeRepository.findByName(tradingPlaceName));
            model.addAttribute("goodsInTradingPlace", goods);
            model.addAttribute("resultCount", goods.size());
        }
        return "services/3";
    }


}
