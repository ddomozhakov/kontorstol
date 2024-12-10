package ru.dwe.kontorstol.lager.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.dwe.kontorstol.lager.constants.ItemType;

@Data
@AllArgsConstructor
public class ItemsAmountRq {
    private ItemType type;
}
