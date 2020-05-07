/*
 * ---------------------------------------------------------------------------
 * File name: GreetingController.java
 * Project name: sp2020final
 * ---------------------------------------------------------------------------
 * Creator's name and email: Jake Gillenwater, Gillenwaterj@etsu.edu
 * Course:  CSCI 3610
 * Creation Date: 4/18/2020
 * ---------------------------------------------------------------------------
 */

package edu.etsu.csci3610.sp2020final.controllers;

import edu.etsu.csci3610.sp2020final.configurations.DatabaseInterchange;
import edu.etsu.csci3610.sp2020final.models.Account;
import edu.etsu.csci3610.sp2020final.models.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;

@Controller
public class CreateAccountController implements WebMvcConfigurer {
    @Autowired
    DatabaseInterchange di;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/createAccount").setViewName("createAccount");
    }

    @GetMapping("/createAccount")
    public String CreateAccountForm(Account account) {
        return "createAccount";
    }

    @PostMapping("/createAccount")
    public String CreateAccountSubmit(Account account, BindingResult br){
        if (br.hasErrors()) {
            return "createAccount";
        }
        di.CreateAccount(account);
        return "redirect:login";
    }

}