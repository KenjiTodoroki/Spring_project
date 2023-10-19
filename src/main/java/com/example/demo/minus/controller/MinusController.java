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
	public String doGet(@RequestParam("num1") Integer num1, @RequestParam("num2") Integer num2, Model model) {
		String answer = "";
		
		answer = String.valueOf(minusService.Minus(num1, num2));

		model.addAttribute("answer", answer);

		return "minus.html"; // .htmlは省略可(分かりやすいようにURLマッピングと統一)
	}
}