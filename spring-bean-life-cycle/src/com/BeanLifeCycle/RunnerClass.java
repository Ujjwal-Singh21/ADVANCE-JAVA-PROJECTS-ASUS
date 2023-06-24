package com.BeanLifeCycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RunnerClass {

	public static void main(String[] args) throws Exception {
		// This does the same work: ApplicationContext(I) <- AbstractApplicationContext(AC) <- ClassPathXmlApplicationContext(C)
		//-----------------------------------------------------------------------------------------------------------------------
//		AbstractApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		StudentDao student = context.getBean("studentdaobean", StudentDao.class);
		student.selectAllStudentRecords();
//		student.deleteStudentRecord(3);
		
//		Hello hello = context.getBean("helloBean", Hello.class);
//		hello.sample();
		
		// Manually closing IOC container because its a StandAlone application.
		// If its a StandAlone application, creating and destroying container object are done by us manually.
		// If its a web application using SpringBoot/WEB MVC, then we don't need to create and destroy container object.
		//--------------------------------------------------------------------------------------------------------------
		((ClassPathXmlApplicationContext)context).close();
		
		// It is used for same purpose as close method is used above, the dif between this and close() method is this method
		// will execute once the main thread ends, so once all your code gets executed, this method executes and closes the 
		// container. So it won't give us any Exception irrespective of the line no we are calling it.
		// However close() method executes immediately at the line where it gets invoked.
		//--------------------------------------------------------------------------------------------------------------------
//		((ClassPathXmlApplicationContext)context).registerShutdownHook();
	}

}
