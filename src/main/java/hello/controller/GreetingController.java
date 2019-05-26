package hello.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hello.beans.restful.APIResult;
import hello.beans.restful.AuthorizationRequest;
import hello.beans.restful.AuthorizationResponse;
import hello.enums.Status;
import hello.service.AuthorizationService;

// view controller
@Controller
public class GreetingController {

	private Logger logger = LoggerFactory.getLogger(GreetingController.class);
	
	public GreetingController() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping(value = "/girl", method = RequestMethod.GET)
	public String greeting(@RequestParam(name="", required=false, defaultValue="World") String name,
			Model model) {
		model.addAttribute("name", name);
		
		return "Greeting2"; // -- >> src/main/resources/templates/greeting.html
		// Attention : At tomcat "Greeting2" need to fit the correct word case.
	}
	
	
}
