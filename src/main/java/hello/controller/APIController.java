package hello.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import hello.beans.restful.APIResult;
import hello.beans.restful.AuthorizationRequest;
import hello.beans.restful.AuthorizationResponse;
import hello.enums.Status;
import hello.service.AuthorizationService;

@RestController
public class APIController {
	
	private Logger logger = LoggerFactory.getLogger(APIController.class);
	
	public APIController() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	AuthorizationService authorizationService;
	
	@RequestMapping(value = "/auth", method = RequestMethod.POST , produces = "application/json")
    public APIResult<AuthorizationResponse> getAuthorization(@RequestBody @Valid AuthorizationRequest authorizationRequest,
    		HttpServletRequest req, HttpServletResponse res) {
    	
		logger.info("getAuthorization: " + authorizationRequest.getUser());
		AuthorizationResponse authorizationResponse= authorizationService.getAuth(authorizationRequest);
		
		if(authorizationResponse.getToken() == null)
			return new APIResult<AuthorizationResponse>(Status.AUTHURIZATION_INVALIDATE,authorizationResponse);
		
		return new APIResult<AuthorizationResponse>(Status.SUCCESS, authorizationResponse);
    }
	
	

}
