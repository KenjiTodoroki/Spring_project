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
	public String doGet(@RequestParam("num1") String strNum1, @RequestParam("num2") String strNum2,
			HttpServletRequest request, HttpServletResponse response, Model model)
			throws ServletException, IOException {
		// requestのgetParameterメソッドで送信されたデータ(calculatorMenu)を取得
		String calculatorMenu = request.getParameter("calculatorMenu");
		// 数値型の初期値
		int result = 0;
		String message = null;
		/*　
		 * switch文でcalculatorMenuのoption valueの値によって分岐させる
		 * そのvalue値に対するCalculatorServiceクラスのメソッドを呼び出し計算処理をする
		 */
		if (strNum1.equals("") || strNum2.equals("")) {
			message = "何も入力されていません";
		} else {
			int num1 = Integer.parseInt(strNum1);
			int num2 = Integer.parseInt(strNum2);

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
				try {
					result = calculatorService.divide(num1, num2);
				} catch (ArithmeticException e) {
					message = "0では割り切れません";
					break;
				}
			}
		}

		if (message == null) {
			model.addAttribute("result", result);
		} else {
			model.addAttribute("message", message);
		}

		return "calculator.html";
	}
}