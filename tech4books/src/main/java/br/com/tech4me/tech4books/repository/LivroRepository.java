package br.com.tech4me.tech4books.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.tech4me.tech4books.model.Livro;

public interface LivroRepository extends MongoRepository<Livro, String> {

  List<Livro> findByAutor(String autor);

}
