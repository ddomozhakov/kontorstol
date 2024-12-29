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
        jdbcTemplate.queryForObject(query, new Object[]{type, amount}, Integer.class);
    }

    public GetItemsAmountRs getItemsAmount(String type) {
        String query = "SELECT Amount FROM lager_main WHERE Type = ?";
        return new GetItemsAmountRs(jdbcTemplate.queryForObject(query, new Object[]{type}, Integer.class));
    }

    public void updateItemsAmount(String type, int amount) {
        String query = "UPDATE lager_main SET Amount = ? WHERE Type = ?;";
        jdbcTemplate.queryForObject(query, new Object[]{type}, Integer.class);
    }

    public void deleteItem(String type) {
        String query = "DELETE FROM lager_main WHERE Type = ?;";
        jdbcTemplate.queryForObject(query, new Object[]{type}, Integer.class);
    }

    // TODO добавить исключения и AdviceController
    // TODO добавить логирование>
    // TODO добавить интесепторы и валидаторы с feign
    // TODO покрыть тестами CRUD для ItemsAmountDao
    // TODO удалить лишние классы и тестовые файлы
    // TODO проверить покрытие тестами
}
