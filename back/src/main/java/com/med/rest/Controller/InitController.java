package com.med.rest.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class InitController {

	@GetMapping
	public String helloWorld() {
		return "Starting Application";
	}
}
