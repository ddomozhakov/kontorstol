package ru.dwe.kontorstol.lager.db;

import io.zonky.test.db.AutoConfigureEmbeddedDatabase;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import ru.dwe.kontorstol.lager.repository.ItemsAmountDao;

import static io.zonky.test.db.AutoConfigureEmbeddedDatabase.DatabaseProvider.ZONKY;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureEmbeddedDatabase(provider = ZONKY)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class LagerDBTests {
	private static final String BASE_LOCAL_URL = "http://localhost:8080/";
	private static final String LAGER_BASE_URL = "api/v1/lager";
	private static final String LAGER_GET_ITEMS_AMOUNT_ENDPOINT_URL = "/items";
	private static final String LAGER_BASE_ITEMS_AMOUNT_URL = BASE_LOCAL_URL + LAGER_BASE_URL + LAGER_GET_ITEMS_AMOUNT_ENDPOINT_URL;
	private static final String LAGER_SQL_INIT_SUCCESS = "/sql/getItemsAmountSuccess.sql";

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ItemsAmountDao itemsAmountDao;

	@Sql(LAGER_SQL_INIT_SUCCESS)
	@Test
	void getChairsAmountSuccess() throws Exception {
		this.mockMvc.perform(get(LAGER_BASE_ITEMS_AMOUNT_URL + "/get?type=chair"))
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("itemsAmount\":11")))
				.andDo(print());
	}

	@Disabled
	@Sql(LAGER_SQL_INIT_SUCCESS)
	@Test
	void getChairsAmountNoItem() throws Exception {
		this.mockMvc.perform(get(LAGER_BASE_ITEMS_AMOUNT_URL + "/get?type=onion"))
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("itemsAmount\":11")))
				.andDo(print());
	}

	@Sql(LAGER_SQL_INIT_SUCCESS)
	@Test
	void createItemSuccess() throws Exception {
		Resource resource = new ClassPathResource("json/rq/createItemSuccess.json");
		String rq = new String(resource.getInputStream().readAllBytes());

		this.mockMvc.perform(post(LAGER_BASE_ITEMS_AMOUNT_URL + "/create")
						.contentType(MediaType.APPLICATION_JSON)
						.content(rq))
				.andExpect(status().isOk())
				.andDo(print());
		assertEquals(7, itemsAmountDao.getItemsAmount("shelf").getItemsAmount());
	}

	@Sql(LAGER_SQL_INIT_SUCCESS)
	@Test
	void updateItemAmountSuccess() throws Exception {
		Resource resource = new ClassPathResource("json/rq/updateItemSuccess.json");
		String rq = new String(resource.getInputStream().readAllBytes());

		this.mockMvc.perform(post(LAGER_BASE_ITEMS_AMOUNT_URL + "/update")
						.contentType(MediaType.APPLICATION_JSON)
						.content(rq))
				.andExpect(status().isOk())
				.andDo(print());
		assertEquals(3, itemsAmountDao.getItemsAmount("table").getItemsAmount());
	}

	@Sql(LAGER_SQL_INIT_SUCCESS)
	@Test
	void deleteItemtSuccess() throws Exception {
		this.mockMvc.perform(delete(LAGER_BASE_ITEMS_AMOUNT_URL + "/delete?type=chair"))
				.andExpect(status().isOk())
				.andDo(print());
	}


}
