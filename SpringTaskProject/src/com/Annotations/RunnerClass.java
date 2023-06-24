package com.Annotations;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class RunnerClass {

	public static void main(String[] args) throws Exception, BeansException{
		
		ApplicationContext context = new AnnotationConfigApplicationContext(ConfigPlayer.class);
		
		Player player = context.getBean("playerBean", Player.class);
		
		System.out.println(player);

	}
}
