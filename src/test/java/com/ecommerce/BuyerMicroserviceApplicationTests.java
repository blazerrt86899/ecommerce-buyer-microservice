package com.ecommerce;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import com.ecommerce.model.Buyer;
import com.ecommerce.service.BuyerService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.MOCK, classes = {BuyerMicroserviceApplication.class})
public class BuyerMicroserviceApplicationTests {

	private MockMvc mockMvc;
	
	@Autowired
	WebApplicationContext webApplicationContext;
	
	@MockBean
	private BuyerService buyerServiceMock;
	
	@Before
	public void setUp() {
		 this.mockMvc = webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	public void should_CreateAccount_When_ValidRequest() throws Exception {
		
		when(buyerServiceMock.createBuyer(any(Buyer.class))).thenReturn(new Buyer());
		
		mockMvc.perform(post("/buyer/signup")
			   .contentType(MediaType.APPLICATION_JSON)
			   .content("{ \"username\": \"abhi\", \"password\":\"abhi\",\"emailId\":\"Tromu98@gmail.com\",\"mobileNumber\":\"7906146618\" }")						
			   .accept(MediaType.APPLICATION_JSON))
			   .andExpect(status().isCreated())
			   .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
			   .andExpect(header().string("Location", "/buyer/signup"))
			   .andExpect(jsonPath("$.username").value("abhi"))			   
			   .andExpect(jsonPath("$.password").value("SAVINGS"))
			   .andExpect(jsonPath("$.emailId").value("Tromu98@gmail.com"))
			   .andExpect(jsonPath("$.mobileNumber").value("7906146618"));		
	}
	
	@Test
	public void contextLoads() {
	}

}
