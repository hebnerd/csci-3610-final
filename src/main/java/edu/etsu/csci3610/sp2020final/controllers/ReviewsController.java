/*
 * ---------------------------------------------------------------------------
 * File name: ReviewsController.java
 * Project name: sp2020final
 * ---------------------------------------------------------------------------
 * Creator's name and email: Matt Harrison, harrisonms1@etsu.edu
 * Course:  CSCI 3610
 * Creation Date: 4/30/2020
 * ---------------------------------------------------------------------------
 */

package edu.etsu.csci3610.sp2020final.controllers;

import edu.etsu.csci3610.sp2020final.configurations.DatabaseInterchange;
import edu.etsu.csci3610.sp2020final.models.Account;
import edu.etsu.csci3610.sp2020final.models.Review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ReviewsController {
	@Autowired
	private DatabaseInterchange di;

	@GetMapping ("/reviews")
	public String showAllReviews(Model model) {
		model.addAttribute("reviews", di.GetAllReviews());
		return "reviews";
	}
}
