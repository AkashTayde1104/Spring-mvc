package com.tech.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

public class HomeController {
	@RequestMapping("/log")
public void m1()
{
	System.out.println("Hello Java"); 
}

}
