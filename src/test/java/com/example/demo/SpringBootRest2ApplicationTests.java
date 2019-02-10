package com.example.demo;

import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.bean.User;
import com.example.controller.UserController;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringBootRest2ApplicationTests {

    final String BASE_URL = "http://localhost:8083/";

    @Autowired
    private UserController testUserController;
    
    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(testUserController).build();
    }
    
    @Test
    public void testSayHelloWorld() throws Exception{
        //Mocking Controller
    	testUserController = mock(UserController.class);

    	User mockUser = new User("1","Tayyba Fatima","1234","6789","Street#2,XYZ City");
       
    	ObjectMapper mapper = new ObjectMapper();
    	mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    	 
    	
//         this.mockMvc.perform(post("/services/latest/validation/dsd")
//    	            .header("Origin", BASE_URL)
//    	            .header("Accept", "application/json")
//    	            .content(mapper.writeValueAsBytes(mockUser))
//    	            .contentType(MediaType.APPLICATION_JSON))
//    	            .andExpect(status().isOk())
//    	            .andDo(MockMvcResultHandlers.print());
    	
    	  this.mockMvc.perform(post("/user")
    	            .contentType(MediaType.APPLICATION_JSON)
    	            .content(mapper.writeValueAsBytes(mockUser)))
    	            .andDo(print())
    	            .andExpect(status().is2xxSuccessful());

    }
    
    public static String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            final String jsonContent = mapper.writeValueAsString(obj);
            return jsonContent;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    } 

    
	@Test
	public void contextLoads() {
	}

}

