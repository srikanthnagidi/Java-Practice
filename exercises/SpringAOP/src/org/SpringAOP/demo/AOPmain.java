package org.SpringAOP.demo;

import org.SpringAOP.demo.Service.ShapeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPmain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		ShapeService shapeService = context.getBean("shapeService", ShapeService.class);
		System.out.println(shapeService.getCircle().getName());
		System.out.println("The area of the circle is : " + shapeService.getCircle().getArea());
		shapeService.getTriangle().setName("Another Triangle");
		System.out.println(shapeService.getTriangle().getName());
	}

}
