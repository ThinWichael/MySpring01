package hello.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.Before;

//import javax.ws.rs.core.MediaType;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.http.MediaType;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import com.google.gson.Gson;

import hello.DemoSpring01ApplicationTests;
import hello.beans.restful.AuthorizationRequest;
import hello.beans.restful.AuthorizationResponse;
import hello.service.AuthorizationService;

@RunWith(SpringRunner.class)
@WebMvcTest(APIController.class)
@ContextConfiguration(classes={DemoSpring01ApplicationTests.class}) // for debug 

public class APIControllerTest {

//	private final static ObjectMapper objectMapper = new ObjectMapper();
	
	@Autowired
    private MockMvc mockMvc;
	
	// assume AuthorizationService is not finished but we need to write controller test code
	@MockBean
	private AuthorizationService authorizationService;

	@Before
	void setMockOutput() {
//		when(authorizationService.checktest()).thenReturn("test OK!");
		when(authorizationService.getAuth(ArgumentMatchers.any(AuthorizationRequest.class))).thenReturn(new AuthorizationResponse());
//		assertThat(authorizationResponse).isNotNull();
	}
	
	@Test
	public void getAuthorizationTest() throws Exception {
		
		System.out.println(authorizationService.checktest());
		
		Gson gson = new Gson();
	    String jsonStr = gson.toJson(new AuthorizationRequest("Poter", "123456"));
	    
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/auth")
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonStr);
		
		mockMvc.perform(requestBuilder)
		.andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
        .andExpect(jsonPath("$.data").exists());
		
		//some expect example
//		mockMvc
//        .perform(asyncDispatch(mvcResult))
//        .andExpect(status().isOk())
//        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//        .andExpect(jsonPath("$.content", Matchers.hasSize(1)))
//        .andExpect(jsonPath("$.content[0].email").value("user2@example.com"))
//        .andExpect(jsonPath("$.totalElements").value(2))
//        .andExpect(jsonPath("$.totalPages").value(2))
//        .andExpect(jsonPath("$.size").value(1))
//        .andExpect(jsonPath("$.number").value(1))
//        .andExpect(jsonPath("$.first").value("false"))
//        .andExpect(jsonPath("$.last").value("true"));

		//		.andExpect(model().hasNoErrors())
//		.andExpect(MockMvcResultMatchers.flash().attributeExists("data"))
//		.andExpect(redirectedUrl("/admin/posts"))
		
		// Test with actual spring server container:
//		MvcResult mvcResult= mockMvc.perform(requestBuilder).andReturn();
//		MockHttpServletResponse response = mvcResult.getResponse();
		
//		assertThat(response.getStatus()).isEqualTo(200);
//		assertThat(response.getHeader(HttpHeaders.LOCATION)).containsIgnoringCase("http://localhost/api/auth");
		
	}

}
