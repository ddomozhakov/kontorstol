package ru.dwe.kontorstol.lager.service;

import ru.dwe.kontorstol.lager.model.ItemsAmountRq;
import ru.dwe.kontorstol.lager.model.ItemsAmountRs;

public interface LagerService {
    ItemsAmountRs getItemsAmount(ItemsAmountRq rq);
}
