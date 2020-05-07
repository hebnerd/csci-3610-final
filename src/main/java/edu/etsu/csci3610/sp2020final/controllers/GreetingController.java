/*
 * ---------------------------------------------------------------------------
 * File name: GreetingController.java
 * Project name: sp2020final
 * ---------------------------------------------------------------------------
 * Creator's name and email: Matt Harrison, harrisonms1@etsu.edu
 * Course:  CSCI 3610
 * Creation Date: 4/7/2020
 * ---------------------------------------------------------------------------
 */

package edu.etsu.csci3610.sp2020final.controllers;

import edu.etsu.csci3610.sp2020final.models.Greeting;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;

@Controller
public class GreetingController implements WebMvcConfigurer {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/response").setViewName("response");
	}

	@GetMapping("/greeting")
	public String greetingForm(Greeting greeting) {
		return "greeting";
	}

	@PostMapping("/greeting")
	public String greetingSubmit(@Valid Greeting greeting, BindingResult br){
		if (br.hasErrors()) {
			return "greeting";
		}

		return "response";
	}

}