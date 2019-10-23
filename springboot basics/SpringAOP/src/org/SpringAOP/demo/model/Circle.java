package org.SpringAOP.demo.model;

public class Circle {
	private String name;
	private int radius;
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
		System.out.println("Circle Setter is called");
	}
	
	public double getArea() {
		return Math.PI*radius*radius;
	}
}
