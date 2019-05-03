package com.capgemini.calculator.aspects1;


import org.springframework.stereotype.*;
import org.aspectj.lang.annotation.*;
import com.capgemini.spring.Calculator.*;
import com.capgemini.spring.CalculatorImp.*;


@Component
@Aspect
public class ValidationAspects{
	@Before("execution(* com.capgemini.spring.Calculator.add(..))")
	public void ValidateAdd()
	{
		System.out.println("Before Execution...!!");

	}
	@After("execution(* com.capgemini.spring.Calculator.divide(..))")
	public void ValidateDivide()
	{
		System.out.println("After Execution...!!");
	}
}