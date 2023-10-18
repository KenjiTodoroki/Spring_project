package com.example.demo.calculator.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.calculator.service.CalculatorService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class CalculatorController {

	private final CalculatorService calculatorService;

	public CalculatorController(CalculatorService calculatorService) {
		this.calculatorService = calculatorService;
	}

	@GetMapping("calculator")
	public String doGet(Model model) {

		return "calculator";
	}

	@PostMapping("calculator.html")
	/*
	 * ・HttpServletRequest クライアントからのリクエストに関する情報を取得
	 * ・HttpServletResponse クライアントにHTML情報を出力
	 */
	public String doGet(@RequestParam("num1") Integer num1, @RequestParam("num2") Integer num2,
			HttpServletRequest request, HttpServletResponse response, Model model)
			throws ServletException, IOException {
		// requestのgetParameterメソッドで送信されたデータ(calculatorMenu)を取得
		String calculatorMenu = request.getParameter("calculatorMenu");
		// 数値型の初期値
		int result = 0;
		/*　
		 * switch文でcalculatorMenuのoption valueの値によって分岐させる
		 * そのvalue値に対するCalculatorServiceクラスのメソッドを呼び出し計算処理をする
		 */
		switch (calculatorMenu) {
		case ("plus"):
			result = calculatorService.plus(num1, num2);
			break;
		case ("minus"):
			result = calculatorService.minus(num1, num2);
			break;
		case ("multi"):
			result = calculatorService.multi(num1, num2);
			break;
		case ("division"):
			result = calculatorService.divide(num1, num2);
			break;
		}

		model.addAttribute("result", result);

		return "calculator.html";
	}
}