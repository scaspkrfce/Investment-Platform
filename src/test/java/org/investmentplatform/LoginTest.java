package org.investmentplatform;

import org.investmentplatform.service.AuthenticationRestController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@ExtendWith(SpringExtension.class)
@WebMvcTest(AuthenticationRestController.class)

class LoginTest {
	
	@Autowired
	private MockMvc mvc;
	
	@Test
	void test() throws Exception
	{
		RequestBuilder request = MockMvcRequestBuilders.get("/login");
		MvcResult result = mvc.perform(request).andReturn();
		String string = result.getResponse().getContentAsString();
		System.out.println(string);
	}

}
