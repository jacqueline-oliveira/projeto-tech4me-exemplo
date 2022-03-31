package br.com.tech4me.tech4authors.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.tech4me.tech4authors.model.Autor;

public interface AutorRepository extends MongoRepository<Autor, String>{
  
}
