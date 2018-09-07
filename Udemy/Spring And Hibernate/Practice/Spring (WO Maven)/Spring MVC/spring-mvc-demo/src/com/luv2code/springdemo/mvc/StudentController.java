package com.luv2code.springdemo.mvc;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Value("#{countryOptions}") 
	private Map<String, String> countryOptions;
	
	@Value("#{languageOptions}")
	private Map<String, String> languageOptions;
	
	@RequestMapping("showForm")
	public String showForm(Model theModel) {
		
		// create a new Student object
		Student theStudent = new Student();
		
		// add student object to the model
		theModel.addAttribute("student", theStudent);
		
		// Countries codes from properties file
		theModel.addAttribute("theCountryOptions", countryOptions);
		theModel.addAttribute("theLanguageOptions", languageOptions);
		
		return "student-form";
	}
	
	@RequestMapping("processForm")
	public String processForm(@ModelAttribute("student") Student theStudent) {
		
		System.out.println("theStudent: " + theStudent.getFirstName()
									+ " " + theStudent.getLastName()
				);
		
		System.out.println("Student Country: " + theStudent.getCountry());
		
		return "student-confirmation";
	}
	

}
