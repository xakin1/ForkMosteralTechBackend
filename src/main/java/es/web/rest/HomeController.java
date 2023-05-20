package es.web.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping({"/", "/home", "/status"})
	public String getStatus() {
		return "Application is up and running";
	}
}
