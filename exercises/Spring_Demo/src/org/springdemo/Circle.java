package org.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Circle implements Shape {
	
	private Point centre;
	
	public Point getCentre() {
		return centre;
	}
	//@Autowired
	//@Qualifier("circleRelated")
	
	//@Resource annotation can do dependency injection by name
	//if name is not defined bellow Resource annotation will search for a bean with the same name as "centre" that is the variable name
	@Resource(name = "pointC")
	public void setCentre(Point centre) {
		this.centre = centre;
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("Drawing Circle :");
		System.out.println("Circle : Point is " + centre.getX() + " " + centre.getY());
	}
	//by using @PostConstruct the following method will  be called before a circle is initialized
	//no need to provide default init method in .xml file id @PostConstruct annotation is used
	@PostConstruct
	public void initializeCircle() {
		System.out.println("Init of circle");
	}
	
	//similar to @PostConstruct method, PreDestroy annotation is used to call destroy method for bean
	@PreDestroy
	public void destroyCircle() {
		System.out.println("Destroy of circle");
	}
}
