package com.capgemini.demo.test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.capgemini.demo.MathApplication;
import com.capgemini.demo.service.CalculatorService;

public class MathApplicationTest {
	@Mock
	private CalculatorService service;
	
	@InjectMocks
	MathApplication application= new MathApplication(service);
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	public void testPerformAdditionWithPositiveIntegers() {
		when(service.addition(6, 4)).thenReturn(10);
		assertEquals(10, application.performAddition(6, 4));
	}
	public void testPerformAdditionWithNegativeIntegers() {
		when(service.addition(-6, -4)).thenReturn(10);
		assertEquals(10, application.performAddition(-6, -4));
	}
	public void testPerformAdditionWithNegativePositiveIntegers() {
		when(service.addition(-3, 2)).thenReturn(-1);
	}
	public void testPerformAdditionWithPositiveNegativeIntegers() {
		when(service.addition(6, -4)).thenReturn(2);
		assertEquals(2, application.performAddition(6, -4));
	}
	public void testPerformSubtractionWithPositiveIntegers() {
		when(service.subtraction(10,4)).thenReturn(6);
		assertEquals(6, application.performSubtraction(10, 4));
	}
	public void testPerformSubtractionWithNegativeIntegers() {
		when(service.subtraction(-2, -3)).thenReturn(1);
		assertEquals(1, application.performSubtraction(-2, -3));
	}
	public void testPerformSubtractionWithNegativePositiveIntegers() {
		when (service.subtraction(-3, 2)).thenReturn(-5);
		assertEquals(-5, application.performSubtraction(-3, 2));
	}
	public void testPerformSubtractionWithPositiveNegativeIntegers() {
		when (service.subtraction(2, -3)).thenReturn(5);
		assertEquals(5, application.performSubtraction(2, -3));
	}
	public void testPerformDivisionWithPositiveIntegers() {
		when(service.division(6,3)).thenReturn(2);
		assertEquals(2, application.performDivision(6, 3));
	}
	public void testPerformDivisionWithNegativeIntegers() {
		when(service.division(-6,-3)).thenReturn(2);
		assertEquals(2, application.performDivision(-6, -3));
	}
	public void testPerformDivisionWithNegativePositiveIntegers() {
		when(service.division(-6,3)).thenReturn(-2);
		assertEquals(-2, application.performDivision(-6, 3));
	}
	public void testPerformDivisionWithPositiveNegativeIntegers() {
		when(service.division(6,-3)).thenReturn(-2);
		assertEquals(-2, application.performDivision(6, -3));
	}
	public void testPerformMultiplicationWithPositiveIntegers() {
		when (service.multiplication(2, 3)).thenReturn(6);
		assertEquals(6,application.performMultiplication(2, 3));
	}
	public void testFindFactorialWithPositiveInteger() {
		when(service.factorial(5)).thenReturn(120L);
		assertEquals(120, application.findFactorial(5));
	}
	@Test(expected = ArithmeticException.class)
	public void testPerformDivisionWithDivisorZero() {
	doThrow(new ArithmeticException("/ by zero")).when(service).division(10, 0);
	application.performDivision(10, 0); 
	}

}
