package com.cesarjunior.curso.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cesarjunior.curso.model.Estudante;
import com.cesarjunior.curso.repository.EstudanteRepository;

@RestController
public class EstudanteController {
	
	@Autowired
	private EstudanteRepository estudanteRepository;
	
	//Método que retorna todos os clientes:
	
	@RequestMapping(value="/estudantes", method=RequestMethod.GET)
	public List<Estudante> listStudent(){
		return this.estudanteRepository.findAll();
	}
	
	//Buscar estudante por id:
	
	@RequestMapping(value="estudantes/{id}", method=RequestMethod.GET)
	public Optional<Estudante> findById(@PathVariable String id) {
		return this.estudanteRepository.findById(id);
	}
	
	//Inserir estudante:
	@RequestMapping(value="estudantes", method=RequestMethod.POST)
	public Estudante save(@RequestBody Estudante estudante) {
		return this.estudanteRepository.save(estudante);
	}
	
	//Remover estudante por id:
	@RequestMapping(value="estudantes/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Estudante> remove(@PathVariable String id) {
		this.estudanteRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
	
	
	//Buscar estudante por nome com like:
	@RequestMapping(value="estudantes/{nome}/nome", method=RequestMethod.GET)
	public List<Estudante> findByName(@PathVariable String nome) {
		return this.estudanteRepository.findByNomeLikeIgnoreCase(nome);
	}

}
