package com.example.demo.AnimalsAPI.service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.AnimalsAPI.data.Animals;
import com.example.demo.AnimalsAPI.repository.AnimalsAPIRepository;

@Service
public class AnimalsAPIService {

	private final AnimalsAPIRepository animalsAPIRepository;

	public AnimalsAPIService(AnimalsAPIRepository animalsAPIRepository) {
		this.animalsAPIRepository = animalsAPIRepository;
	}

	public List<Animals> getAnimalsList() throws IOException {
		Animals[] animalsList = animalsAPIRepository.getAnimalsList();

		return Arrays.asList(animalsList);
	}

	public List<Animals> getAnimals(int index) throws IOException {
		Animals[] animals = animalsAPIRepository.getAnimals(index);

		return Arrays.asList(animals);
	}
}