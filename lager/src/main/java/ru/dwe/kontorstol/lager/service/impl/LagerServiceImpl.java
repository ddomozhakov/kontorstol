package ru.dwe.kontorstol.lager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import ru.dwe.kontorstol.lager.model.rest.CreateItemRq;
import ru.dwe.kontorstol.lager.model.rest.GetItemsAmountRs;
import ru.dwe.kontorstol.lager.model.rest.UpdateItemRq;
import ru.dwe.kontorstol.lager.repository.ItemsAmountDao;
import ru.dwe.kontorstol.lager.service.LagerService;

@Service
public class LagerServiceImpl implements LagerService {

    @Autowired
    ItemsAmountDao itemsAmountDao;

    public GetItemsAmountRs getItemsAmount(String type) {
        return itemsAmountDao.getItemsAmount(type);
    }

    public void createItem(CreateItemRq rq) {
        itemsAmountDao.createItem(rq.getType(), rq.getAmount());
    }

    public void updateItemsAmount(UpdateItemRq rq) {
        itemsAmountDao.updateItemsAmount(rq.getType(), rq.getAmount());
    }

    public void deleteItem(@RequestParam(required = true) String type) {
        itemsAmountDao.deleteItem(type);
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