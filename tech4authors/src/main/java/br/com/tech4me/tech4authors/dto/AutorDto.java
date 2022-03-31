package br.com.tech4me.tech4authors.dto;

import java.util.List;

import br.com.tech4me.tech4authors.shared.Livro;

public class AutorDto {
  private String id;
  private String nome;
  private String nacionalidade;
  private String genero;
  private List<Livro> livros;

  public String getId() {
    return id;
  }
  public List<Livro> getLivros() {
    return livros;
  }
  public void setLivros(List<Livro> livros) {
    this.livros = livros;
  }
  public void setId(String id) {
    this.id = id;
  }
  public String getNome() {
    return nome;
  }
  public void setNome(String nome) {
    this.nome = nome;
  }
  public String getNacionalidade() {
    return nacionalidade;
  }
  public void setNacionalidade(String nacionalidade) {
    this.nacionalidade = nacionalidade;
  }
  public String getGenero() {
    return genero;
  }
  public void setGenero(String genero) {
    this.genero = genero;
  }

}
