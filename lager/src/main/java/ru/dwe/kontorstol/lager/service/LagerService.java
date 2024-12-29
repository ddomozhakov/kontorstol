package ru.dwe.kontorstol.lager.service;

import ru.dwe.kontorstol.lager.model.rest.CreateItemRq;
import ru.dwe.kontorstol.lager.model.rest.GetItemsAmountRs;
import ru.dwe.kontorstol.lager.model.rest.UpdateItemRq;

public interface LagerService {
    GetItemsAmountRs getItemsAmount(String rq);
    void createItem(CreateItemRq rq);
    void updateItemsAmount(UpdateItemRq rq);
    void deleteItem(String type);
}
