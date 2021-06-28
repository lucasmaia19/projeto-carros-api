package com.example.projetocarros.entity;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Carros {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String nome;
	
//	@ManyToOne
//	private CompraCarro compraCarro;
	
//	@OneToMany
//	private List<CompraCarro> compraCarro = new ArrayList<>();
	
}
