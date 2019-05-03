package com.capgemini.calculator.aspects;
import com.capgemini.spring.Calculator.*;
import com.capgemini.spring.CalculatorImp.*;

import org.springframework.context.ApplicationContext;

public class CalculatorTest
{

	public static void main(String args[])
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		Calculator calculator = context.getBean(Calculator.class);
		calculator.add(30,50);
		calculator.divide(20.1,30.1);	
	}



}