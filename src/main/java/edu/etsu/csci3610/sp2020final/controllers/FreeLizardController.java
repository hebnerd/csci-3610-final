/*
 * ---------------------------------------------------------------------------
 * File name: FreeLizardController.java
 * Project name: sp2020final
 * ---------------------------------------------------------------------------
 * Creator's name and email: Destin Hebner, hebnerd@etsu.edu
 * Course:  CSCI 3610
 * Creation Date: 5/8/2020
 * Controller for the free lizard raffle sign up.
 * ---------------------------------------------------------------------------
 */

package edu.etsu.csci3610.sp2020final.controllers;

import edu.etsu.csci3610.sp2020final.models.FreeLizard;
import edu.etsu.csci3610.sp2020final.models.Greeting;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;

@Controller
public class FreeLizardController implements WebMvcConfigurer {

    // Add route for submission page
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/freeLizardResponse").setViewName("freeLizardResponse");
    }

    // Normal GET mapping, shows the free lizard raffle page
    @GetMapping("/freeLizard")
    public String freeLizardForm(FreeLizard freeLizard) {
        return "freeLizard";
    }

    // For POST request with free lizard sign up info
    // If there are no errors, it shows the response page
    @PostMapping("/freeLizard")
    public String freeLizardSubmit(@Valid FreeLizard lizard, BindingResult br){
        if (br.hasErrors()) {
            return "freeLizard";
        }

        return "freeLizardResponse";
    }

}