package org.springdemo;

import org.springframework.context.ApplicationEvent;

public class DrawEvent extends ApplicationEvent{

	public DrawEvent(Object source) {
		super(source);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Draw event Occured";
	}
}
