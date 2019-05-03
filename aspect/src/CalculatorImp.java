package com.capgemini.spring.Calculator;
import com.capgemini.spring.Calculator.*;

import org.springframework.stereotype.*;
@Component
public class CalculatorImp implements Calculator1{
	public void add(Integer a, Integer b)
	{
		System.out.println("addition is : "+(a + b));
	}
	
	public void divide(Double num1,Double num2)
	{
		System.out.println("division is : "+(num1/num2));
	}



}