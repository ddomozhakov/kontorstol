package ru.dwe.kontorstol.lager.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.dwe.kontorstol.lager.controller.LagerController;
import ru.dwe.kontorstol.lager.model.rest.ItemsAmountRs;
import ru.dwe.kontorstol.lager.service.LagerService;

@RestController
@RequestMapping("api/v1/lager")
public class LagerControllerImpl implements LagerController {

    @Autowired
    LagerService studentServiceImpl;

    @GetMapping("/items")
    public ItemsAmountRs getItemsAmount(@RequestParam(required = true) String type) {
        return studentServiceImpl.getItemsAmount(type);
    }
}
