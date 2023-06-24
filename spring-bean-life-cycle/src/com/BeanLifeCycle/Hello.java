package com.BeanLifeCycle;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Hello implements InitializingBean, DisposableBean{
	
//	public void init() {
//		System.out.println("Hello class init method");
//	}
//	
//	public void destroy() {
//		System.out.println("Hello class destroy method");
//	}
//	
	public void sample() {
		System.out.println("Hello class sample method");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Hello class afterPropertiesSet method");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("Hello class overriden destroy method");
	}
}
