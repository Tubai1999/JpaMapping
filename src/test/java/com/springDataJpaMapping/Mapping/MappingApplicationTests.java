package com.springDataJpaMapping.Mapping;

import com.springDataJpaMapping.Mapping.Entities.User;
import com.springDataJpaMapping.Mapping.service.JwtService;
import com.springDataJpaMapping.Mapping.service.RestClientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClient;

@SpringBootTest
class MappingApplicationTests {
	@Autowired
	private RestClientService restClientService;

	@Autowired
	private JwtService jwtService;

	@Test
	public void getPostFromThirdPartyAPI(){
				String returnedDAta = restClientService.getPostFromThirdPartyAPI();
		System.out.println(returnedDAta);

	}

	@Test
	public void createPostToThirdPartyAPI(){
		String returnedData = restClientService.createPostToThirdPartyAPI();
		System.out.println("inside createpost");
		System.out.println(returnedData);
	}

	@Test
	public void generateToken(){
		User user = new User(1L,"tridib@mail.com","sdfbsjb","tridib");
		String token = jwtService.generateToken(user);
		System.out.println(token);
	}

}
