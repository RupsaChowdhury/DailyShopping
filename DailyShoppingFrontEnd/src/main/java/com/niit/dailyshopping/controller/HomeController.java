package com.niit.dailyshopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	
	
	@GetMapping("/")
	public  ModelAndView home()
	{
		
		System.out.println("hello");
		ModelAndView mv=new ModelAndView ("home");
		mv.addObject("username","Rupsa");
		//add object to mv
		return mv;
	}
	
	
	@GetMapping("/login")
	public   ModelAndView  login()
	{
		ModelAndView mv=new ModelAndView("home");
		mv.addObject("isUserClickedlogin",true);
		return mv;
	}
	
	@GetMapping("/register")
	public   ModelAndView  register()
	{
		ModelAndView mv=new ModelAndView("home");
		mv.addObject("isUserClickedregister",true);
		return mv;
	}


}
