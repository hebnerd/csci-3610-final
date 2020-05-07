/*
 * ---------------------------------------------------------------------------
 * File name: GiftShopController.java
 * Project name: sp2020final
 * ---------------------------------------------------------------------------
 * Creator's name and email: Jake Gillenwater, Gillenwaterj@etsu.edu
 * Course:  CSCI 3610
 * Creation Date: 4/29/2020
 * ---------------------------------------------------------------------------
 */

package edu.etsu.csci3610.sp2020final.controllers;

import edu.etsu.csci3610.sp2020final.models.GiftShopForm;
import edu.etsu.csci3610.sp2020final.models.Greeting;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;

@Controller
public class GiftShopController implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/giftShopResponse").setViewName("giftShopResponse");
    }

    @GetMapping("/giftShop")
    public String giftShopFormPage(GiftShopForm purchase) {
        return "giftShop";
    }

    @PostMapping("/giftShop")
    public String giftShopSubmit(@Valid GiftShopForm purchase, BindingResult br){
        System.out.println("totalCost: " + purchase.getTotalCost());
        if (br.hasErrors()) {

            return "giftShop";
        }

        return "giftShopResponse";
    }

}