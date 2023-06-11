package com.poly.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.poly.filter.AdminFilter;
import com.poly.filter.LoginFilter;

@Configuration
public class WebMVCConfig implements WebMvcConfigurer{

	@Autowired 
	LoginFilter loginFilter;
	
	@Autowired
	AdminFilter adminFilter;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		registry.addInterceptor(loginFilter)
		.addPathPatterns("/logout","/video/favorite","/video/my-history","/admin/*","/change-pass","/my-profile");
		
		registry.addInterceptor(adminFilter)
		.addPathPatterns("/admin/**");
		
	}
}
