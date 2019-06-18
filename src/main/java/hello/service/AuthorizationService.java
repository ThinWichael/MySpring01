package hello.service;

import org.springframework.stereotype.Service;

import hello.beans.restful.AuthorizationRequest;
import hello.beans.restful.AuthorizationResponse;

@Service
public class AuthorizationService {

	public AuthorizationResponse getAuth(AuthorizationRequest authorizationRequest) {
		AuthorizationResponse authorizationResponse = new AuthorizationResponse();
		System.out.println("authorizationResponse is :" + authorizationResponse == null? "YES":"NO");
		// for test ! Actually we need to access database 
		if("testUser".equals(authorizationRequest.getUser()) &&
				"12345678".equals(authorizationRequest.getPwd())){
			authorizationResponse.setToken("tyrhejigdw");
		}
		// for test ! Actually we need to access database 
		
		return authorizationResponse;
	}
	
	public String checktest() {
		return "test OK!";
	}
	
//	public AuthorizationService() {
//		// TODO Auto-generated constructor stub
//	}

}
