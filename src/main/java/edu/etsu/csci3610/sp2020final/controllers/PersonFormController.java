/*
 * ---------------------------------------------------------------------------
 * File name: PersonFormController.java
 * Project name: sp2020final
 * ---------------------------------------------------------------------------
 * Creator's name and email: Matt Harrison, harrisonms1@etsu.edu
 * Course:  CSCI 3610
 * Creation Date: 4/7/2020
 * ---------------------------------------------------------------------------
 */

package edu.etsu.csci3610.sp2020final.controllers;

import javax.validation.Valid;

import edu.etsu.csci3610.sp2020final.models.PersonForm;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Controller
public class PersonFormController implements WebMvcConfigurer {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/results").setViewName("results");
	}

	@GetMapping("/form")
	public String showForm(PersonForm personForm) {
		return "form";
	}

	@PostMapping("/form")
	public String checkPersonInfo(@Valid PersonForm personForm, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "form";
		}

		return "results";
	}
}
