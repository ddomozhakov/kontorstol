package ru.dwe.kontorstol.lager.service.impl;

import org.springframework.stereotype.Service;
import ru.dwe.kontorstol.lager.model.ItemsAmountRq;
import ru.dwe.kontorstol.lager.model.ItemsAmountRs;
import ru.dwe.kontorstol.lager.service.LagerService;

@Service
public class LagerServiceImpl implements LagerService {
    public ItemsAmountRs getItemsAmount(ItemsAmountRq rq) {




        return new ItemsAmountRs(10);
    }
}



//create table lager_main
//        ( Type varchar primary key,
//          Amount integer
//        );
//
//
//insert into lager_main (Type, Amount) values
//('Table', 15),
//        ('Chair', 11);
//
//
//select * from lager_main