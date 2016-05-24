package ru.nsu.ccfit.dymova.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.nsu.ccfit.dymova.entities.TradingPlace;
import ru.nsu.ccfit.dymova.entities.TradingPlaceType;
import ru.nsu.ccfit.dymova.jpa.TradingPlaceRepository;
import ru.nsu.ccfit.dymova.jpa.TradingPlaceTypeRepository;

@Controller
@RequestMapping("/entity/trading_place")
public class TradingPlaceController {
    private static Logger l = LoggerFactory.getLogger(TradingPlaceController.class);
    @Autowired
    private TradingPlaceRepository placeRepository;
    @Autowired
    private TradingPlaceTypeRepository typeRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String readTradingPlace(Model model) {
        model.addAttribute("tradingPlaces", placeRepository.findAll());
        return "entity/trading_place/trading_place";
    }



    @RequestMapping(method = RequestMethod.POST)
    public String addTradingPlace(@RequestParam("name") String name, @RequestParam("type") String type) {
        TradingPlaceType currentType = typeRepository.findByName(type);
        if (currentType == null) {
            currentType = new TradingPlaceType(type);
        }
        TradingPlace currentPlace = new TradingPlace(name, currentType);

        placeRepository.save(currentPlace);
        return "redirect:/entity/trading_place";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/delete/{id}")
    public String deleteTradingPlace(@PathVariable("id") Long id){
        placeRepository.delete(id);
        l.info("delete" + id);
        return "redirect:/entity/trading_place";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/edit/{id}")
    public String getTradingPlaceForEdit(Model editModel, @PathVariable("id") Long id) {
        TradingPlace place = placeRepository.findOne(id);
        editModel.addAttribute("tradingPlaceName", place.getName());
        editModel.addAttribute("tradingPlaceType", place.getType().getName());
        return "entity/trading_place/edit_trading_place";

    }

    @RequestMapping(method = RequestMethod.POST, value = "/edit/{id}")
    public String editTradingPlace(@RequestParam("name") String name, @RequestParam("type") String type, @PathVariable("id") Long id) {
        TradingPlace place = placeRepository.getOne(id);

        place.setName(name);

        TradingPlaceType currentType = typeRepository.findByName(type);
        if (currentType == null) {
            currentType = new TradingPlaceType(type);
        }
        place.setType(currentType);

        placeRepository.save(place);
        return "redirect:/entity/trading_place";
    }

}
