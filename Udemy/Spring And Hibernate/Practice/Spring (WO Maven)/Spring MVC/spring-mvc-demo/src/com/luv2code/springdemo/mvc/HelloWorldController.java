package com.luv2code.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("hello")
public class HelloWorldController {

	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}

	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}

	// new controller method to read form data and
	// add data to the model

	@RequestMapping("/processFormVersionTwo")
	public String letsShoutDude(HttpServletRequest request, Model model) {

		// adding to the model
		model.addAttribute("message", "Yo! " + request.getParameter("studentName").toUpperCase());

		return "helloworld";
	}

	// new controller method to read form data and
	// add data to the model USING 

	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree(@RequestParam("studentName") String studentName, Model model) {

		// adding to the model
		model.addAttribute("message", "Yo version 3! " + studentName.toUpperCase());

		return "helloworld";
	}

}
