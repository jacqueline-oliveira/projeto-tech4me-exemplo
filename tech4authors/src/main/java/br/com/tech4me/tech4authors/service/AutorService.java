package br.com.tech4me.tech4authors.service;

import java.util.List;
import java.util.Optional;

import br.com.tech4me.tech4authors.dto.AutorDto;

public interface AutorService {
  AutorDto cadastrarAutor(AutorDto autor);
  List<AutorDto> obterAutores();
  Optional<AutorDto> obterAutorPorId(String id);
  void excluirAutor(String id);
  AutorDto alterarAutor(String id, AutorDto autor);
  
}
