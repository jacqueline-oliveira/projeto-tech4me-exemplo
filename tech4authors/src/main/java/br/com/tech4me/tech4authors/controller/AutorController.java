package br.com.tech4me.tech4authors.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tech4me.tech4authors.dto.AutorComLivrosDto;
import br.com.tech4me.tech4authors.dto.AutorDto;
import br.com.tech4me.tech4authors.service.AutorService;

@RestController
@RequestMapping("/api/autores")
public class AutorController {

  private ModelMapper mapper = new ModelMapper();

  @Autowired
  private AutorService service;
  
  @GetMapping
  public ResponseEntity<List<AutorDto>> obterTodos() {
    return new ResponseEntity<>(service.obterAutores(), HttpStatus.OK);

  }

  @GetMapping("/{id}")
  public ResponseEntity<AutorComLivrosDto> obterPorId(@PathVariable String id) {
    Optional<AutorDto> autor = service.obterAutorPorId(id);

    if (autor.isPresent()) {
      return new ResponseEntity<>(mapper.map(autor.get(), AutorComLivrosDto.class), HttpStatus.OK);
    }

    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  @PostMapping
  public ResponseEntity<AutorDto> cadastrarAutor(@RequestBody AutorDto autor){
    return new ResponseEntity<>(service.cadastrarAutor(autor), HttpStatus.CREATED);
  }

  @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> excluirAutorPorId(@PathVariable String id){
        service.excluirAutor(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AutorDto> atualizarAutor(@PathVariable String id, @RequestBody @Valid AutorDto autor){
        return new ResponseEntity<>(service.alterarAutor(id, autor), HttpStatus.ACCEPTED);
    }



  
}
