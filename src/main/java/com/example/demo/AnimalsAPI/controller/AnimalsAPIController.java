package com.example.demo.AnimalsAPI.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.AnimalsAPI.data.Animals;
import com.example.demo.AnimalsAPI.service.AnimalsAPIService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class AnimalsAPIController {

	private final AnimalsAPIService animalsAPIService;

	public AnimalsAPIController(AnimalsAPIService animalsAPIService) {
		this.animalsAPIService = animalsAPIService;
	}

	@GetMapping("animalsSearch.html")
	public String doGet(Model model) {
		return "animalsSearch.html";
	}

	@GetMapping("animalsDetail.html")
	public String doGet(HttpServletRequest request, HttpServletResponse response, Model model)
			throws ServletException, IOException {

		String animalsMenu = request.getParameter("animalsMenu");

		List<Animals> animals = new ArrayList<>();

		if ("dog".equals(animalsMenu)) {
			animals = animalsAPIService.dog();

		} else if ("cat".equals(animalsMenu)) {
			animals = animalsAPIService.cat();

		} else if ("lesserPanda".equals(animalsMenu)) {
			animals = animalsAPIService.lesserPanda();

		} else if ("lion".equals(animalsMenu)) {
			animals = animalsAPIService.lion();

		} else if ("seaOtter".equals(animalsMenu)) {
			animals = animalsAPIService.seaOtter();

		} else if ("pig".equals(animalsMenu)) {
			animals = animalsAPIService.pig();

		} else if ("test".equals(animalsMenu)) {
			animals = animalsAPIService.test();

		}

		model.addAttribute("animals", animals);

		return "animalsDetail.html";
	}
}