package com.example.projetocarros.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class CompraCarro {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nome;
	
//	private LocalDate data;
	
	private Date data;
	
//	@OneToMany
//	private List<Carros> carros = new ArrayList<>();
	
	@ManyToOne
	private Carros carros;
	
	private Float valor;
}
