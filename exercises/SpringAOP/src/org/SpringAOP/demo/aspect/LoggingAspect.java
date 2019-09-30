package org.SpringAOP.demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect

public class LoggingAspect {
	
	// loggingAdvice  method will be called before all the getters execute  
	@Before("execution( * org.SpringAOP.demo.model.*.get*(..))")
	public void loggingAdvice() {
		System.out.println("Advice run: Get method is called");
	}
	@Before("execution( * org.SpringAOP.demo.model.*.get*(..))")
	public void secondAdvice() {
		System.out.println("Second Advice executed");
	}
}
