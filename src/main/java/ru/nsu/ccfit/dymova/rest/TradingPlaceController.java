package ru.nsu.ccfit.dymova.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.nsu.ccfit.dymova.entities.TradingPlace;
import ru.nsu.ccfit.dymova.entities.TradingPlaceType;
import ru.nsu.ccfit.dymova.jpa.TradingPlaceRepository;
import ru.nsu.ccfit.dymova.jpa.TradingPlaceTypeRepository;

@RestController
@RequestMapping("/entity/trading_place")
public class TradingPlaceController {
    @Autowired
    private TradingPlaceRepository placeRepository;
    @Autowired
    private TradingPlaceTypeRepository typeRepository;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView readTradingPlaceFeatures(@ModelAttribute("model") ModelMap model) {
        model.addAttribute("tradingPlaces", placeRepository.findAll());
        return new ModelAndView("trading_place");
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ModelAndView readTradingPlaceFeatures(@ModelAttribute("model") ModelMap model, @PathVariable("id") String id) {
        model.addAttribute("tradingPlaces", placeRepository.findAll());
        return new ModelAndView("trading_place");
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView readTradingPlaceFeatures(@RequestParam("name") String name, @RequestParam("type") String type, @ModelAttribute("model") ModelMap model) {
        TradingPlaceType currentType = typeRepository.findByName(type);
        if (currentType == null) {
            currentType = new TradingPlaceType(type);
        }
        TradingPlace currentPlace = new TradingPlace(name, currentType);

        placeRepository.save(currentPlace);
//        return readTradingPlaceFeatures(model);
        return new ModelAndView("redirect:trading_place");
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ModelAndView deleteTradingPlace(@PathVariable("id") Long id){
        placeRepository.delete(id);

        return new ModelAndView("/");
//        return new ModelAndView("redirect:/");
    }


}
