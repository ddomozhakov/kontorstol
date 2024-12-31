package ru.dwe.kontorstol.lager.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.dwe.kontorstol.lager.model.rest.GetItemsAmountRs;

@Repository
@RequiredArgsConstructor
public class ItemsAmountDao {

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASS = "pam";
    private final JdbcTemplate jdbcTemplate;

    public void createItem(String type, int amount) {
        String query = "INSERT INTO lager_main (Type, Amount) VALUES (?, ?)";
        jdbcTemplate.update(query, new Object[]{type, amount});
    }

    public GetItemsAmountRs getItemsAmount(String type) {
        String query = "SELECT Amount FROM lager_main WHERE Type = ?";
        Integer amount = jdbcTemplate.queryForObject(query, new Object[]{type}, Integer.class);
        return new GetItemsAmountRs(amount);
    }

    public void updateItemsAmount(String type, int amount) {
        String query = "UPDATE lager_main SET Amount = ? WHERE Type = ?";
        jdbcTemplate.update(query, amount, type);
    }

    public void deleteItem(String type) {
        String query = "DELETE FROM lager_main WHERE Type = ?;";
        jdbcTemplate.update(query, type);
    }

    // TODO добавить ветку develop и оформлять MR в нее
    // TODO добавить исключения и AdviceController
    // TODO добавить логирование>
    // TODO добавить интесепторы и валидаторы с feign
    // TODO покрыть тестами CRUD для ItemsAmountDao
    // TODO проверить покрытие тестами
}


//@Value("${db.url}")
//private String dbUrl;
//
//@Value("${db.user}")
//private String user;
//
//@Value("${db.password}")
//private String password;