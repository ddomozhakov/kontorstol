package ru.dwe.kontorstol.lager.controller;

import org.springframework.web.bind.annotation.RequestParam;
import ru.dwe.kontorstol.lager.model.rest.CreateItemRq;
import ru.dwe.kontorstol.lager.model.rest.GetItemsAmountRs;
import ru.dwe.kontorstol.lager.model.rest.UpdateItemRq;

public interface LagerController {
    GetItemsAmountRs getItemsAmount(@RequestParam(required = true) String type);
    void createItem(CreateItemRq rq);
    void updateItemsAmount(UpdateItemRq rq);
    void deleteItem(@RequestParam(required = true) String type);
}