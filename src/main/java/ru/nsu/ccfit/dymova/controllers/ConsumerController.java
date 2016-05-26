package ru.nsu.ccfit.dymova.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.nsu.ccfit.dymova.entities.*;
import ru.nsu.ccfit.dymova.jpa.ConsumerRepository;
import ru.nsu.ccfit.dymova.jpa.GoodRepository;
import ru.nsu.ccfit.dymova.jpa.SaleRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("entity/consumer")
public class ConsumerController {
    @Autowired
    private ConsumerRepository consumerRepository;

    @Autowired
    private GoodRepository goodRepository;

    @Autowired
    private SaleRepository salesRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String getConsumers(Model model) {
        List<Consumer> consumers = consumerRepository.findAll();
        model.addAttribute("consumers", consumers);
        model.addAttribute("goods", goodRepository.findAll());
        model.addAttribute("resultCount", consumers.size());

        return "entity/consumer/consumer";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addConsumer(@RequestParam("name") String name) {
        Consumer consumer = consumerRepository.findByName(name);
        if (consumer == null) {
            consumerRepository.save(new Consumer(name));
        }
        return "redirect:/entity/consumer";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/delete/{id}")
    public String deleteConsumer(@PathVariable("id") Long id) {
        consumerRepository.delete(id);
        return "redirect:/entity/consumer";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/edit/{id}")
    public String getConsumerForEdit(Model editModel, @PathVariable("id") Long id) {
        Consumer consumer = consumerRepository.findOne(id);
        editModel.addAttribute("consumerName", consumer.getName());
        return "entity/consumer/edit_consumer";

    }

    @RequestMapping(method = RequestMethod.POST, value = "/edit/{id}")
    public String editConsumer(@RequestParam("name") String name, @PathVariable("id") Long id) {
        Consumer consumer = consumerRepository.getOne(id);
        consumer.setName(name);

        consumerRepository.save(consumer);
        return "redirect:/entity/consumer";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/filter")
    public String getFilteredProvider(@RequestParam("period") String period, @RequestParam("good") String goodName,
                                      @RequestParam("count") Integer count, Model model) throws ParseException {


        Good good = goodRepository.findByName(goodName);

        String[] strings = period.split(" - ");
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        Date date1 = formatter.parse(strings[0]);
        Date date2 = formatter.parse(strings[1]);
        List<Sale> result = salesRepository.findByGoodAndCountLessThanAndDateBetween(good, count, date1, date2);

        List<Consumer> consumers = result.stream().map(Sale::getConsumer).distinct().collect(Collectors.toList());
        model.addAttribute("consumers", consumers);
        model.addAttribute("goods", goodRepository.findAll());
        model.addAttribute("resultCount", consumers.size());

        return "/entity/consumer/consumer";
    }

}
