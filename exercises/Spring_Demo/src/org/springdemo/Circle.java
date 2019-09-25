package org.springdemo;

public class Circle implements Shape {
	
	private Point centre;
	
	public Point getCentre() {
		return centre;
	}

	public void setCentre(Point centre) {
		this.centre = centre;
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("Drawing Circle :");
		System.out.println("Circle : Point is " + centre.getX() + " " + centre.getY());
	}

}
