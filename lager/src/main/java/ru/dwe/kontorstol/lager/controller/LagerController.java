package ru.dwe.kontorstol.lager.controller;

import ru.dwe.kontorstol.lager.model.ItemsAmountRq;
import ru.dwe.kontorstol.lager.model.ItemsAmountRs;

public interface LagerController {
    ItemsAmountRs getItemsAmount(ItemsAmountRq rq);
}
