package com.springmvc.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.format.FormatterRegistry;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.springmvc.convertors.CreditCardConvertorObjectToString;
import com.springmvc.convertors.CreditCardConvertorStringToObject;
import com.springmvc.formatter.BillAmountFormatter;
import com.springmvc.formatter.CreditCardFormatter;
import com.springmvc.formatter.PhoneNumberFormatter;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages= {"com.springmvc"})
@PropertySource("classpath:email.properties")
public class LoveCalculatorAppConfig implements WebMvcConfigurer {
	
	@Autowired
	private Environment env;
	
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	@Bean
	public JavaMailSender getJavaMailSender() {
		JavaMailSenderImpl javaMailSenderImpl = new JavaMailSenderImpl();
		
		javaMailSenderImpl.setHost(env.getProperty("mail.host"));
		javaMailSenderImpl.setUsername(env.getProperty("mail.username"));
		javaMailSenderImpl.setPassword(env.getProperty("mail.password"));
		javaMailSenderImpl.setPort(getIntProperties("mail.port")); 

		javaMailSenderImpl.setJavaMailProperties(getProperties());
		return javaMailSenderImpl;
	}

	// for mail sending purpose
	public Properties getProperties() {
		Properties mailProperties = new Properties();
		mailProperties.put("mail.smtp.starttls.enable", true);
		mailProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		return mailProperties;
	}
	
	// utility
	public Integer getIntProperties(String key) {
		String properties = env.getProperty(key);
		return Integer.parseInt(properties);
	}
	
	// for setting where my message.properties file exists
	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		return messageSource;
	}
	
	// To link above method with spring, to get path of 'message.properties' file with spring,
	// telling spring to look for above method to search for properties file
	@Bean
	public LocalValidatorFactoryBean validator() {
		LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
		localValidatorFactoryBean.setValidationMessageSource(messageSource());
		return localValidatorFactoryBean;
	}
	
	// finally validate our custom validator
	@Override
	public Validator getValidator() {
		return validator();
	}
	
	// registering formatters with spring framework
	// There is also another way to register our custom formatter with spring inside Controller's @InitBinder method
	// We do that with the help of WebDataBinder object as -> binder.addCustomFormatter(new PhoneNumberFormatter())
	@Override
	public void addFormatters(FormatterRegistry registry) {
		System.out.println("Inside add formatter config class");
//		registry.addFormatter(new PhoneNumberFormatter());
//		registry.addFormatter(new CreditCardFormatter());
//		registry.addFormatter(new BillAmountFormatter());
		
		// registering our Converters here with spring
//		registry.addConverter(new CreditCardConvertorObjectToString());
//		registry.addConverter(new CreditCardConvertorStringToObject());
	}
}
