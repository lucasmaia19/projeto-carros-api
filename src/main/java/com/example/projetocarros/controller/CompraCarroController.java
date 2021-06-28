package com.example.projetocarros.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;

import com.example.projetocarros.entity.CompraCarro;
import com.example.projetocarros.repository.CompraCarroRepository;

@RestController
@RequestMapping("/compra-carro")
public class CompraCarroController {

	@Autowired
	private CompraCarroRepository repository;

	@PostMapping
	public CompraCarro cadastrar(@ModelAttribute CompraCarro compraCarro) throws Exception {
		
		try {
			// pega a data de hoje
			Date data = new Date(System.currentTimeMillis());
			SimpleDateFormat formatarDate = new SimpleDateFormat("dd-MM-yyyy");

			// formata a data de hoje de String para Date
			String dataAtual = (formatarDate.format(data));
			Date dataFormatada = formatarDate.parse(dataAtual); 

			if(dataFormatada.before(compraCarro.getData())){
//				System.out.println("data futura invalido");

//				throw new Exception();
				throw new InvalidAlgorithmParameterException("Data futura invalida");
			} else {

			}
		} catch (RuntimeException e) {
//			e.printStackTrace();
		}

		return repository.save(compraCarro);

	}

	@GetMapping
	public List<CompraCarro> listatodos(CompraCarro compraCarro) throws ParseException {	
		
//		SimpleDateFormat formatarDate = new SimpleDateFormat("dd-MM-yyyy");
//		String dataList = formatarDate.format(compraCarro.getData());
//		Date dataFormatada = formatarDate.parse(dataList); 
//		compraCarro.setData(dataFormatada);

		return repository.findAll();

	}

	@GetMapping("/{id}")
	public Optional<CompraCarro> listarUm(@PathVariable Long id) {
		return repository.findById(id);

	}

	@DeleteMapping("/{id}")
	public String deletar(@PathVariable Long id) {
		repository.deleteById(id);
		return null;

	}

	@PutMapping("/{id}")
	public CompraCarro atualizar(@ModelAttribute CompraCarro compraCarro, @PathVariable Long id) throws InvalidAlgorithmParameterException, ParseException {

		try {
			// pega a data de hoje
			Date data = new Date(System.currentTimeMillis());
			SimpleDateFormat formatarDate = new SimpleDateFormat("dd-MM-yyyy");

			// formata a data de hoje de String para Date
			String dataAtual = (formatarDate.format(data));
			Date dataFormatada = formatarDate.parse(dataAtual); 

			if(dataFormatada.before(compraCarro.getData())) {
//				System.out.println("data futura invalido");

//				throw new Exception();
				throw new InvalidAlgorithmParameterException("Data futura INVALIDA");
			} else {

			}
		} catch (RuntimeException e) {
//			e.printStackTrace();
		}

		CompraCarro compraCarroSaved = repository.findById(id).get();

		BeanUtils.copyProperties(compraCarro, compraCarroSaved, "id");

		return repository.save(compraCarroSaved);

	}

}
