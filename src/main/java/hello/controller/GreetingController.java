package hello.controller;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import org.apache.log4j.Logger;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

// view controller
@Controller
public class GreetingController {

	private Logger logger =  Logger.getLogger("GreetingController");
	
	public GreetingController() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping(value = "/girl", method = RequestMethod.GET)
	public String greeting(@RequestParam(name="", required=false, defaultValue="World") String name,
			Model model) {
		model.addAttribute("name", name);
		
		logger.info("!! This is log4j log!!!!!!");
		logger.debug("!! This is log4j log , debug!!!!!!");
		
		return "Greeting2"; // -- >> src/main/resources/templates/greeting.html
		// Attention : At tomcat "Greeting2" need to fit the correct word case.
	}
	
	
}
