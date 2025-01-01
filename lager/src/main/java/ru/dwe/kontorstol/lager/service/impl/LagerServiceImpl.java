package ru.dwe.kontorstol.lager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import ru.dwe.kontorstol.lager.constants.BusinessProcess;
import ru.dwe.kontorstol.lager.model.rest.CreateItemRq;
import ru.dwe.kontorstol.lager.model.rest.GetItemsAmountRs;
import ru.dwe.kontorstol.lager.model.rest.UpdateItemRq;
import ru.dwe.kontorstol.lager.repository.ItemsAmountDao;
import ru.dwe.kontorstol.lager.service.LagerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class LagerServiceImpl implements LagerService {

    private static final Logger logger = LoggerFactory.getLogger(LagerServiceImpl.class);

    @Autowired
    ItemsAmountDao itemsAmountDao;

    public GetItemsAmountRs getItemsAmount(String type) {
        logger.info("Начало обработки запроса {}", BusinessProcess.GETITEMSAMOUNT);
        GetItemsAmountRs rs = itemsAmountDao.getItemsAmount(type);
        logger.info("Заспрос {} успешно обработан", BusinessProcess.GETITEMSAMOUNT);
        return rs;
    }

    public void createItem(CreateItemRq rq) {
        logger.info("Начало обработки запроса {}", BusinessProcess.CREATEITEM);
        itemsAmountDao.createItem(rq.getType(), rq.getAmount());
        logger.info("Заспрос {} успешно обработан", BusinessProcess.CREATEITEM);
    }

    public void updateItemsAmount(UpdateItemRq rq) {
        logger.info("Начало обработки запроса {}", BusinessProcess.UPDATEITEMSAMOUNT);
        itemsAmountDao.updateItemsAmount(rq.getType(), rq.getAmount());
        logger.info("Заспрос {} успешно обработан", BusinessProcess.UPDATEITEMSAMOUNT);
    }

    public void deleteItem(@RequestParam(required = true) String type) {
        logger.info("Начало обработки запроса {}", BusinessProcess.DELETEITEM);
        itemsAmountDao.deleteItem(type);
        logger.info("Заспрос {} успешно обработан", BusinessProcess.DELETEITEM);
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