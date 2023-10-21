package com.example.demo.AnimalsAPI.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.AnimalsAPI.data.Animals;
import com.example.demo.AnimalsAPI.service.AnimalsAPIService;

import jakarta.servlet.ServletException;

@Controller
public class AnimalsAPIController {

	private final AnimalsAPIService animalsAPIService;

	public AnimalsAPIController(AnimalsAPIService animalsAPIService) {
		this.animalsAPIService = animalsAPIService;
	}

	@GetMapping("animalsSearch")
	public String doGet(Model model) throws IOException {
		List<Animals> animalsList = animalsAPIService.getAnimalsList();

		model.addAttribute("animalsList", animalsList);

		return "animalsSearch";
	}

	@GetMapping("animalsDetail")
	public String doGet(@RequestParam int animalsMenu, Model model)
			throws ServletException, IOException {

		List<Animals> animals = animalsAPIService.getAnimals(animalsMenu);

		model.addAttribute("animals", animals);

		return "animalsDetail";
	}
}