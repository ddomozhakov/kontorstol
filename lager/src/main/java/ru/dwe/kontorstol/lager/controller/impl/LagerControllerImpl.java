package ru.dwe.kontorstol.lager.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.dwe.kontorstol.lager.controller.LagerController;
import ru.dwe.kontorstol.lager.model.ItemsAmountRq;
import ru.dwe.kontorstol.lager.model.ItemsAmountRs;
import ru.dwe.kontorstol.lager.service.LagerService;

@RestController
@RequestMapping("api/v1/lager")
public class LagerControllerImpl implements LagerController {

    @Autowired
    LagerService studentServiceImpl;

    @GetMapping("/items")
    public ItemsAmountRs getItemsAmount(ItemsAmountRq rq) {
        return studentServiceImpl.getItemsAmount(rq);
    }
}
