package org.springdemo;


import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DrawingApp {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		//initializing method is called first
		context.registerShutdownHook();
		//ApplicationContext factory = new FileSystemXmlApplicationContext("spring.xml");
		//Triangle triangle = (Triangle)factory.getBean("triangle");
		//Shape shape = (Shape)context.getBean("triangle-alias");
		//shape.draw();
		//Triangle tri = (Triangle)context.getBean("triangle2");
		//tri.draw()
		
		Shape shape = (Circle)context.getBean("circle");
		shape.draw();
		
		shape = (Shape)context.getBean("shape");
		shape.draw();
		
		
		//context.getMessage from the properties files 
		//it uses key value pairs to print the message pertaining to that key
		//it has 3 method signatures
		
		System.out.println("from the main method" + context.getMessage("greeting", null, "defalut greeting", null));
		
		
	}
}
