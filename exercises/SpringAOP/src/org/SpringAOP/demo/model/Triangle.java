package org.SpringAOP.demo.model;

public class Triangle {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		System.out.println("Triangle Setter is called");
		//throw(new RuntimeException());
	}
	
	
}
