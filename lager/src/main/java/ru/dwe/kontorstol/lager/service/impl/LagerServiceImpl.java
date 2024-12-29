package ru.dwe.kontorstol.lager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dwe.kontorstol.lager.model.db.ItemsAmountDao;
import ru.dwe.kontorstol.lager.model.rest.ItemsAmountRs;
import ru.dwe.kontorstol.lager.service.LagerService;

@Service
public class LagerServiceImpl implements LagerService {

    @Autowired
    ItemsAmountDao itemsAmountDao;

    public ItemsAmountRs getItemsAmount(String type) {
        return itemsAmountDao.getItemsAmount(type);
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