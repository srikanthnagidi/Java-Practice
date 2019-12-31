package com.example.springboot.aopexample.aspect;


import com.example.springboot.aopexample.model.Employee;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EmployeeServiceAspect {

    @Before(value = "execution(* com.example.springboot.aopexample.service.EmployeeService.*(..)) && args(employee)")
    public void beforeAdvice(JoinPoint joinPoint, Employee employee){
        System.out.println("Before Advice: " + joinPoint.getSignature());

        System.out.println("Creating Employee with name - " + employee.getName() + " and id " + employee.getEmployeeId() );
    }

    @After(value = "execution(* com.example.springboot.aopexample.service.EmployeeService.*(..)) && args(employee)")
    public  void afterAdvice(JoinPoint joinPoint, Employee employee){
        System.out.println("After Advice: " + joinPoint.getSignature());

        System.out.println("Successfully created Employee with name -" + employee.getName() + " and id " + employee.getEmployeeId() );
    }
}
