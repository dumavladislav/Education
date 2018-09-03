package com.luv2code.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {
    
    // need a controller method to show the initial HTML form
    @RequestMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }
    
    // need a controller method to process the HTML form
    @RequestMapping("/processForm")
    public String processForm() {
        return "helloworld";
    }
    
    @RequestMapping("/processFormVersionTwo")
    public String letShoutDude(HttpServletRequest request, Model model) {
        
        String theName = request.getParameter("studentName");
        theName = theName.toUpperCase();
        
        model.addAttribute("message", "Yo! "+theName);
                
        return "helloworld";
    }
    
    
    // @RequestParam annotation example (instead of request.getParameter("studentName")
    @RequestMapping("/processFormVersionThree")
    public String processFormVersionThree(
            @RequestParam("studentName") String theName
            , Model model) {
       
        model.addAttribute("message", "Version 3! "+theName.toUpperCase());
                
        return "helloworld";
    }
    
}
