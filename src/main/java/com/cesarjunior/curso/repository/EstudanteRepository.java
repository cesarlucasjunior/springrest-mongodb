package com.cesarjunior.curso.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cesarjunior.curso.model.Estudante;

public interface EstudanteRepository extends MongoRepository<Estudante, String>{
	
	public List<Estudante> findByNomeLikeIgnoreCase(String name);

}
