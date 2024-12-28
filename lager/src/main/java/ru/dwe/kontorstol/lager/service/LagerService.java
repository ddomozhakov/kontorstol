package ru.dwe.kontorstol.lager.service;

import ru.dwe.kontorstol.lager.model.rest.ItemsAmountRs;

public interface LagerService {
    ItemsAmountRs getItemsAmount(String rq);
}
