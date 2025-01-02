package ru.dwe.kontorstol.lager.repository;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.dwe.kontorstol.lager.exception.DBException;
import ru.dwe.kontorstol.lager.model.rest.GetItemsAmountRs;
import ru.dwe.kontorstol.lager.service.impl.LagerServiceImpl;

@Repository
@RequiredArgsConstructor
public class ItemsAmountDao {

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASS = "pam";
    private static final Logger logger = LoggerFactory.getLogger(LagerServiceImpl.class);

    private final JdbcTemplate jdbcTemplate;

    public void createItem(String type, int amount) {
        String query = "INSERT INTO lager_main (Type, Amount) VALUES (?, ?)";
        jdbcTemplate.update(query, new Object[]{type, amount});
    }

    public GetItemsAmountRs getItemsAmount(String type) {
        String query = "SELECT Amount FROM lager_main WHERE Type = ?";
        Integer amount = 0;
        try {
            amount = jdbcTemplate.queryForObject(query, new Object[]{type}, Integer.class);
        } catch (EmptyResultDataAccessException ex) {
            logger.error("Не существующий тип " + type);
            throw new DBException("Не существующий тип " + type, ex);
        }
        return new GetItemsAmountRs(amount);
    }

    public void updateItemsAmount(String type, int amount) {
        String query = "UPDATE lager_main SET Amount = ? WHERE Type = ?";
        if (jdbcTemplate.update(query, amount, type) != 1) {
            logger.error("Не существующий тип " + type);
            throw new DBException("Не существующий тип " + type);
        }
    }

    public void deleteItem(String type) {
        String query = "DELETE FROM lager_main WHERE Type = ?;";
        if (jdbcTemplate.update(query, type) != 1) {
            logger.error("Не существующий тип " + type);
            throw new DBException("Не существующий тип " + type);
        }
    }
}

// TODO добавить исключения DB и AdviceController
// TODO добавить интесепторы и валидаторы с feign
// TODO вынеести ошибки в отдельный класс констант
// TODO вынести параметры в application.properties

//@Value("${db.url}")
//private String dbUrl;
//
//@Value("${db.user}")
//private String user;
//
//@Value("${db.password}")
//private String password;