package com.sb;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.org.apache.xpath.internal.operations.Quo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.hamcrest.Matchers.containsString;

@SpringBootTest
@AutoConfigureMockMvc
class TestApiApplicationTests {

	@Autowired
	private MockMvc mvc;

	ObjectMapper mapper = new ObjectMapper();


	@Test
	public void customerCalculateQuote() throws Exception {

		Map<String, Map<String, Double>> testCustomerRequest =  new HashMap<>(); //new Map<>(new HashMap<String, Double>());

		Map<String, Double> testCustomerCover = new HashMap<>();
		testCustomerCover.put("tires", 10d);
		testCustomerCover.put("windows", 50d);
		testCustomerRequest.put("covers", testCustomerCover);



		mvc.perform(MockMvcRequestBuilders.post("/v1/quote").contentType(MediaType.APPLICATION_JSON).content(mapper.writeValueAsString(testCustomerRequest))
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}


}
