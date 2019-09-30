package org.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//Component is equivalent defining the class bean in xml file
//<bean id = "circle" class = "org.springdemo.Circle"></bean> this is not required if @Component annotation is used
//if component annotation is used all the instances of the class will have same behavior


@Component
//@Service  even service works instead of component
//@Repository can be used for data
//@Controller can be used if controller is defined
public class Circle implements Shape, ApplicationEventPublisherAware {
	
	private Point centre;
	
	private ApplicationEventPublisher publisher;
	
	@Autowired
	private MessageSource messageSource;
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
		System.out.println(this.messageSource.getMessage("drawing.circle", null, "Default-message", null));
		System.out.println(this.messageSource.getMessage("drawing.point", new Object [] {centre.getX(), centre.getY()}, "Default-message", null));
		System.out.println(" from the draw method inside the class "+ this.messageSource.getMessage("greeting", null, "Default-Greeting", null));
		DrawEvent drawEvent = new DrawEvent(this);
		publisher.publishEvent(drawEvent);
		//System.out.println("");
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

	public MessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
		// TODO Auto-generated method stub
		this.publisher = publisher;
	}
}
