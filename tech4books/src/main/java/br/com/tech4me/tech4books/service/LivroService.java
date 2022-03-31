package br.com.tech4me.tech4books.service;

import java.util.List;
import java.util.Optional;

import br.com.tech4me.tech4books.dto.LivroDTO;

public interface LivroService {
    List<LivroDTO> obterTodosOsLivros();

    Optional<LivroDTO> obterLivroPorId(String id);

    LivroDTO armazenarLivro(LivroDTO livro);

    void excluirLivroPorId(String id);

    LivroDTO atualizarLivro(String id, LivroDTO livro);

    List<LivroDTO> obterPorAutor(String autor);
}
