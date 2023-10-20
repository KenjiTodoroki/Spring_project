package com.example.demo.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

	public int plus(int num1, int num2) {
		return num1 + num2;
	}

	public int minus(int num1, int num2) {
		return num1 - num2;
	}

	public int multi(int num1, int num2) {
		return num1 * num2;
	}

	public int divide(int num1, int num2) {
		if (num2 != 0) {
			return num1 / num2;
		} else {
			throw new ArithmeticException();
		}
	}
}