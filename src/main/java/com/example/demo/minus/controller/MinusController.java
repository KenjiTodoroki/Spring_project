package com.example.demo.minus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.minus.service.MinusService;

@Controller
public class MinusController {

	private final MinusService minusService;

	//	@Autowired　<- spring4.3以降はコンストラクタが1件の場合、省略出来る
	public MinusController(MinusService minusService) {
		this.minusService = minusService;
	}

	@GetMapping("minus") // 最初の表示だけをする為の画面
	public String doGet(Model model) {
		return "minus"; // .htmlは省略可(分かりやすいようにURLマッピングと統一)
	}

	@PostMapping("minus.html") // 計算結果を表示する為の画面
	public String doGet(@RequestParam("num1") String strNum1, @RequestParam("num2") String strNum2, Model model) {
		String answer = "";
		String message = null;
		
		if (strNum1.equals("") || strNum2.equals("")) {
			message = "何も入力されていません";
		} else {
			try {
				int num1 = Integer.parseInt(strNum1);
				int num2 = Integer.parseInt(strNum2);
				answer = String.valueOf(minusService.Minus(num1, num2));
				
			} catch (NumberFormatException e) {
				message = "数字を入力して下さい";
			}
		}

		if (message == null) {
			model.addAttribute("answer", answer);
		} else {
			model.addAttribute("message", message);
		}

		return "minus.html"; // .htmlは省略可(分かりやすいようにURLマッピングと統一)
	}
}