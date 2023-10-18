package com.example.demo.minus.service;

import org.springframework.stereotype.Service;

@Service
public class MinusService {

	public Integer Minus(int num1, int num2) {

		int difference = num1 - num2;

		return difference;
	}
}