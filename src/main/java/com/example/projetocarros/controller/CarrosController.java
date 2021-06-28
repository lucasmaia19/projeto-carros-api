package com.example.projetocarros.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projetocarros.entity.Carros;
import com.example.projetocarros.repository.CarrosRepository;

@RestController
@RequestMapping("/carros")
public class CarrosController {
	
	@Autowired
	private CarrosRepository repository;
	
	@GetMapping
	public List<Carros> listatodos() {
		return repository.findAll();

	}

}
