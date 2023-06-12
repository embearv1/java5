package com.poly.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.LocaleResolver;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class LangugeController {

	@Autowired
    private LocaleResolver localeResolver;


	    @GetMapping("/change-language")
	    public String changeLanguage(@RequestParam("language") String language, HttpServletRequest request, HttpServletResponse response) {
	        if ("en".equals(language)) {
	            localeResolver.setLocale(request, response, new Locale("en"));
	        } else if ("vi".equals(language)) {
	            localeResolver.setLocale(request, response, new Locale("vi"));
	        }
	        return "redirect:/video/home"; // Chuyển hướng lại trang chủ hoặc trang hiện tại
	    }
	
}
