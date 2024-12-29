package ru.dwe.kontorstol.lager.model.db;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.dwe.kontorstol.lager.model.rest.ItemsAmountRs;

@Repository
@RequiredArgsConstructor
public class ItemsAmountDao {

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASS = "pam";
    private final JdbcTemplate jdbcTemplate;

    public ItemsAmountRs getAllUsers(String type) {
        ItemsAmountRs rs = new ItemsAmountRs(0);

        String sql = "SELECT Amount FROM lager_main WHERE Type = ?";
        rs.setItemsAmount(jdbcTemplate.queryForObject(sql, new Object[]{type}, Integer.class));
        return rs;
    }

    // TODO написать и покрыть тестами CRUD для ItemsAmountDao
    // TODO удалить лишние классы и тестовые файлы

}
