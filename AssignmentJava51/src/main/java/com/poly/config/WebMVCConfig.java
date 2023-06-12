package com.poly.config;

import java.nio.charset.StandardCharsets;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

import com.poly.filter.AdminFilter;
import com.poly.filter.LoginFilter;

@Configuration
public class WebMVCConfig implements WebMvcConfigurer{

	@Autowired 
	LoginFilter loginFilter;
	
	@Autowired
	AdminFilter adminFilter;
	
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
          .addResourceHandler("/resources/**")
          .addResourceLocations("/resources/");	
        registry
        .addResourceHandler("/upload/**")
        .addResourceLocations("/upload/");
    }
	
	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource(); 
	
		messageSource.setBasenames(
				"classpath:i18n/label"
		);
		messageSource.setDefaultEncoding(StandardCharsets.UTF_8.name());
		return messageSource;
	}
	
	@Bean
	public LocaleResolver localeResolver() {
		CookieLocaleResolver resolver = new CookieLocaleResolver();
		resolver.setDefaultLocale(new Locale("vi"));
		resolver.setCookieMaxAge(60 * 60 * 24);
		return resolver;
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		registry.addInterceptor(loginFilter)
		.addPathPatterns("/logout","/video/favorite","/video/my-history","/admin/*","/change-pass","/my-profile");
		
		registry.addInterceptor(adminFilter)
		.addPathPatterns("/admin/**");
		
	}
}
