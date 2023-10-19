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

	public List<Animals> dog() throws IOException {

		Animals[] animalsList = animalsAPIRepository.getAnimals();

		return Arrays.asList(animalsList[0]);
	}

	public List<Animals> cat() throws IOException {

		Animals[] animalsList = animalsAPIRepository.getAnimals();

		return Arrays.asList(animalsList[1]);
	}

	public List<Animals> lesserPanda() throws IOException {

		Animals[] animalsList = animalsAPIRepository.getAnimals();

		return Arrays.asList(animalsList[2]);
	}

	public List<Animals> lion() throws IOException {

		Animals[] animalsList = animalsAPIRepository.getAnimals();

		return Arrays.asList(animalsList[3]);
	}

	public List<Animals> seaOtter() throws IOException {

		Animals[] animalsList = animalsAPIRepository.getAnimals();

		return Arrays.asList(animalsList[4]);
	}

	public List<Animals> pig() throws IOException {

		Animals[] animalsList = animalsAPIRepository.getAnimals();

		return Arrays.asList(animalsList[5]);
	}

	public List<Animals> test() throws IOException {

		Animals[] animalsList = animalsAPIRepository.getAnimals();

		return Arrays.asList(animalsList[6]);
	}
}