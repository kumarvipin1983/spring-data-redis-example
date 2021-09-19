package com.javatechie.redis;

import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javatechie.spring.mokito.api.model.Employee;
import com.javatechie.spring.mokito.api.model.Response;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringDataRedisExampleApplicationTests {

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext context;

	ObjectMapper om = new ObjectMapper();

	@Before
	private void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	void contextLoads() {
	}

	@Test
	public void addEmployeeTest() throws Exception {
		Employee emp = new Employee();
		emp.setName("Basant");
		emp.setDept("IT");
		String jsonRequest = om.writeValueAsString(emp); 
		MvcResult result = mockMvc.perform(
				post("/addEmployee").content(jsonRequest).content(MediaType.APPLICATION_JSON_VALUE))
								  .andExpect(status().isOk()).andReturn(); 
		String resultContent = result.getResponse().getContentAsString();
		Response response = om.readValue(resultContent, Response.class);
		assertTrue(response.getStatus() == Boolean.TRUE);
	}

}
