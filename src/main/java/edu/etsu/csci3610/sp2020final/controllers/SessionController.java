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
import edu.etsu.csci3610.sp2020final.models.LoginForm;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
public class SessionController implements WebMvcConfigurer {
    @Autowired
    DatabaseInterchange di;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
    }

    @GetMapping("/login")
    public String LoginForm(LoginForm loginForm) {
        return "login";
    }

    @PostMapping("/login")
    public String LoginSubmit(HttpServletRequest request, HttpServletResponse response, @Valid LoginForm loginForm, BindingResult br){
        if (br.hasErrors()) {
            return "login";
        }

        Account account = di.GetAccountByLogin(loginForm.getEmail(), loginForm.getPassword());
        if(account == null){
            loginForm.setWasSuccessful(false);
            return LoginForm(loginForm);
        }

        // create new accountID and firstName cookies
        Cookie accountId = new Cookie("AccountId", account.getId().toString());
        accountId.setPath("/");
        response.addCookie(accountId);

        Cookie firstName = new Cookie("FirstName", account.getFirstName());
        firstName.setPath("/"); // cookie delivered to this path and all sub-paths ("global")
        response.addCookie(firstName);

        return "home";
    }

    @GetMapping("/logout")
    public String Logout(@NotNull HttpServletRequest request, HttpServletResponse response) {
        // Dump session cookies
        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie c: cookies) {
                if (c.getName().equals("AccountId")) {
                    c.setMaxAge(0);
                    response.addCookie(c);
                }
                if (c.getName().equals("FirstName")) {
                    c.setMaxAge(0);
                    response.addCookie(c);
                };
            }
        }

        return "redirect:home";
    }

}