package com.example.demo.fizzBuzz.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

@Service
public class FizzBuzzService {

	public ArrayList<String> fizzBuzz(int number) {

		ArrayList<String> list = new ArrayList<>();

		for (int i = 0; i <= 100; i++) {
			i += number;

			if (i % 3 == 0 && i % 5 == 0) {
				list.add("FizzBuzz");
			} else if (i % 3 == 0) {
				list.add("Fizz");
			} else if (i % 5 == 0) {
				list.add("Buzz");
			} else {
				list.add(Integer.toString(i));
			}
		}
		return list;
	}
}