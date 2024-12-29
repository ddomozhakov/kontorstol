package ru.dwe.kontorstol.lager.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.dwe.kontorstol.lager.controller.LagerController;
import ru.dwe.kontorstol.lager.model.rest.CreateItemRq;
import ru.dwe.kontorstol.lager.model.rest.GetItemsAmountRs;
import ru.dwe.kontorstol.lager.model.rest.UpdateItemRq;
import ru.dwe.kontorstol.lager.service.LagerService;

@RestController
@RequestMapping("api/v1/lager")
public class LagerControllerImpl implements LagerController {

    @Autowired
    LagerService studentServiceImpl;

    @GetMapping("/items/get")
    public GetItemsAmountRs getItemsAmount(@RequestParam(required = true) String type) {
        return studentServiceImpl.getItemsAmount(type);
    }

    @PostMapping("/items/create")
    public void createItem(CreateItemRq rq) {
        studentServiceImpl.createItem(rq);
    }

    @PostMapping("/items/update")
    public void updateItemsAmount(UpdateItemRq rq) {
        studentServiceImpl.updateItemsAmount(rq);
    }

    @DeleteMapping("/items/delete")
    public void deleteItem(@RequestParam(required = true) String type) {
        studentServiceImpl.deleteItem(type);
    }

}
