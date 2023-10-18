package com.example.demo.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

	public int plus(int num1, int num2) {
		int sum = num1 + num2;
		return sum;
	}

	public int minus(int num1, int num2) {
		int difference = num1 - num2;
		return difference;
	}

	public int multi(int num1, int num2) {
		int product = num1 * num2;
		return product;
	}

	public int divide(int num1, int num2) {
		int quotient = num1 / num2;
		return quotient;
	}
}