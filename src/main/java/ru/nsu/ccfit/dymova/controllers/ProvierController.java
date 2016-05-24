package ru.nsu.ccfit.dymova.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.nsu.ccfit.dymova.entities.Delivery;
import ru.nsu.ccfit.dymova.entities.Good;
import ru.nsu.ccfit.dymova.entities.Provider;
import ru.nsu.ccfit.dymova.jpa.DeliveryRepository;
import ru.nsu.ccfit.dymova.jpa.GoodRepository;
import ru.nsu.ccfit.dymova.jpa.ProviderRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Controller
@RequestMapping("/entity/provider")
public class ProvierController {

    @Autowired
    private ProviderRepository providerRepository;

    @Autowired
    private GoodRepository goodRepository;

    @Autowired
    private DeliveryRepository deliveryRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String getProviders(Model model) {
        List<Provider> providers = providerRepository.findAll();
        model.addAttribute("providers", providers);
        model.addAttribute("goods", goodRepository.findAll());
        model.addAttribute("resultCount", providers.size());

        return "entity/provider/provider";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addProvider(@RequestParam("name") String name) {
        Provider provider = providerRepository.findByName(name);
        if (provider == null) {
            providerRepository.save(new Provider(name));
        }
        return "redirect:/entity/provider";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/delete/{id}")
    public String deleteProvider(@PathVariable("id") Long id) {
        providerRepository.delete(id);
        return "redirect:/entity/provider";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/edit/{id}")
    public String getProviderForEdit(Model editModel, @PathVariable("id") Long id) {
        Provider provider = providerRepository.findOne(id);
        editModel.addAttribute("providerName", provider.getName());
        return "entity/provider/edit_provider";

    }

    @RequestMapping(method = RequestMethod.POST, value = "/edit/{id}")
    public String editProvider(@RequestParam("name") String name, @PathVariable("id") Long id) {
        Provider provider = providerRepository.getOne(id);
        provider.setName(name);

        providerRepository.save(provider);
        return "redirect:/entity/provider";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/filter")
    public String getFilteredProvider(@RequestParam("period") String period, @RequestParam("good") String goodName,
                                      @RequestParam("count") Integer count, Model model) throws ParseException {


        Good good = goodRepository.findByName(goodName);

        String[] strings = period.split(" - ");
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        Date date1 = formatter.parse(strings[0]);
        Date date2 = formatter.parse(strings[1]);
        List<Delivery> result = deliveryRepository.findProviderByGoodAndCountAndDateBetween(good, count, date1, date2);

        List<Provider> providers = result.stream().map(Delivery::getProvider).distinct().collect(Collectors.toList());
        model.addAttribute("providers", providers);
        model.addAttribute("goods", goodRepository.findAll());
        model.addAttribute("resultCount", providers.size());

        return "/entity/provider/provider";
    }

}
