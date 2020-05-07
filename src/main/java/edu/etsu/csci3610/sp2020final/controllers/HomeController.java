	/*
 * ---------------------------------------------------------------------------
 * File name: HomeController.java
 * Project name: sp2020final
 * ---------------------------------------------------------------------------
 * Creator's name and email: Matt Harrison, harrisonms1@etsu.edu
 * Course:  CSCI 3610
 * Creation Date: 4/7/2020
 * ---------------------------------------------------------------------------
 */

package edu.etsu.csci3610.sp2020final.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Arrays;
import java.util.List;

	@Controller
public class HomeController implements WebMvcConfigurer {

	@RequestMapping(value={"/", "/home"}, method=RequestMethod.GET)
	public String homePage(HttpServletRequest request, HttpServletResponse response) {
		return "home";
	}

}
