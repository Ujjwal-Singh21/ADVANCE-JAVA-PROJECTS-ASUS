package com.Annotations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan(basePackages = "com.Annotations")
public class ConfigPlayer {
	
	@Bean(name ="playerBean")
	public Player getPlayerBean() {
		return new Player();
	}

}
