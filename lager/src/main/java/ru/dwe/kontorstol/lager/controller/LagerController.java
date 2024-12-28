package ru.dwe.kontorstol.lager.controller;

import org.springframework.web.bind.annotation.RequestParam;
import ru.dwe.kontorstol.lager.model.rest.ItemsAmountRs;

public interface LagerController {
    ItemsAmountRs getItemsAmount(@RequestParam(required = true) String type);
}
