package ru.dwe.kontorstol.lager.controller;

import ru.dwe.kontorstol.lager.model.rest.ItemsAmountRq;
import ru.dwe.kontorstol.lager.model.rest.ItemsAmountRs;

public interface LagerController {
    ItemsAmountRs getItemsAmount(ItemsAmountRq rq);
}
