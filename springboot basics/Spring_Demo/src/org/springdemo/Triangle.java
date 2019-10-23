package org.springdemo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Triangle implements Shape, ApplicationContextAware, BeanNameAware, InitializingBean, DisposableBean{
	
	
	private String type;
	private int height;

	private Point pointA;
	private Point pointB;
	private Point pointC;
	
	@SuppressWarnings("unused")
	private ApplicationContext applicationContext;
	

	public Point getPointA() {
		return pointA;
	}

	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}

	public Point getPointB() {
		return pointB;
	}

	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}

	public Point getPointC() {
		return pointC;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}

	public int getHeight() {
		return height;
	}

	public String getType() {
		return type;
	}

	//prooperty tag in xml file is using the setter to set the values to the field
	public void setType(String type) { this.type = type; }
	 
	@Override
	public void draw() {
		System.out.println("Drawing a triangle: ");
		System.out.println("\nDraws Triangle " + this.getType() + " with height " + this.getHeight()  
		 + " with cordinates ");
		
		System.out.println( getPointA() + " " + getPointB() + " " + getPointC());
	}

	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		// TODO Auto-generated method stub
		this.applicationContext = context;
	}

	@Override
	public void setBeanName(String beanName) {
		// TODO Auto-generated method stub
		System.out.println("BeanName is " + beanName);
	}
	
	  @Override 
	  public void afterPropertiesSet() throws Exception { 
		  // TODO Auto-generated method stub
		  System.out.println("IntitializingBean init method called for Triangle"); 
	  }
	  
	  @Override 
	  public void destroy() throws Exception { 
		  // TODO Auto-generated method stub
		  System.out.println("Disposable bean destroy method is called for triangle");
	  }
	 
	public void myInit() {
		System.out.println("My init method called for Triangle");
	}
	public void cleanUp() {
		System.out.println("My cleanup method called for Tirangle");
	}
	

}
