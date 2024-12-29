package ru.dwe.kontorstol.lager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import ru.dwe.kontorstol.lager.service.LagerService;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class LagerApplicationTests {

	private static final String BASE_LOCAL_URL = "http://localhost:8080/";
	private static final String LAGER_BASE_URL = "api/v1/lager";
	private static final String LAGER_GET_ITEMS_AMOUNT_ENDPOINT_URL = "/items";
	private static final String LAGER_GET_ITEMS_AMOUNT_URL = BASE_LOCAL_URL + LAGER_BASE_URL + LAGER_GET_ITEMS_AMOUNT_ENDPOINT_URL;

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private LagerService lagerService;

	@Test
	void shouldReturnDefaultMessage() throws Exception {
		this.mockMvc.perform(get(LAGER_GET_ITEMS_AMOUNT_URL)).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("itemsAmount\":10")));
	}
	
//	@Test
//	void greetingShouldReturnMessageFromService() throws Exception {
//		when(service.greet()).thenReturn("Hello, Mock");
//		this.mockMvc.perform(get("/greeting")).andDo(print()).andExpect(status().isOk())
//				.andExpect(content().string(containsString("Hello, Mock")));
//	}

}
