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
import edu.etsu.csci3610.sp2020final.models.Review;
import edu.etsu.csci3610.sp2020final.models.ReviewForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
public class CreateReviewController implements WebMvcConfigurer {
    @Autowired
    DatabaseInterchange di;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/createReview").setViewName("createReview");
    }

    @GetMapping("/createReview")
    public String CreateReviewForm(@CookieValue(value = "AccountId", defaultValue = "-1") String accountId, ReviewForm reviewForm) {
        if(accountId.equals("-1")){
            return "loginToCreateReview";
        }
        Account account = di.GetAccountById(Integer.parseInt(accountId));
        reviewForm.setAccountId(account.getId());
        reviewForm.setAccountName(account.getFirstName() + " " + account.getLastName());
        return "createReview";
    }

    @PostMapping("/createReview")
    public String CreateReviewSubmit(ReviewForm reviewForm, BindingResult br){
        if (br.hasErrors()) {
            // For some reason, the linter won't let me use toString() here. No clue why.
            return CreateReviewForm(reviewForm.getAccountId() + "", reviewForm);
        }

        Account account = di.GetAccountById(reviewForm.getAccountId());
        Review review = new Review();
        review.setAccount(account);
        review.setRating(reviewForm.getRating());
        review.setContent(reviewForm.getContent());

        di.CreateReview(review);
        return "redirect:reviews";
    }

}