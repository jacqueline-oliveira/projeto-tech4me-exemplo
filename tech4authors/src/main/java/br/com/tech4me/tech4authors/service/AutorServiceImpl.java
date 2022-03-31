package br.com.tech4me.tech4authors.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tech4me.tech4authors.dto.AutorDto;
import br.com.tech4me.tech4authors.httpClients.LivroFeignClient;
import br.com.tech4me.tech4authors.model.Autor;
import br.com.tech4me.tech4authors.repository.AutorRepository;

@Service
public class AutorServiceImpl implements AutorService {

  private ModelMapper mapper = new ModelMapper();

  @Autowired
  private LivroFeignClient livroClient;

  @Autowired
  private AutorRepository autorRepository;

  @Override
  public AutorDto cadastrarAutor(AutorDto autor) {
    Autor autorCadastro = mapper.map(autor, Autor.class);
    autorCadastro = autorRepository.save(autorCadastro);
    return mapper.map(autorCadastro, AutorDto.class);
  }

  @Override
  public List<AutorDto> obterAutores() {
    List<Autor> autores = autorRepository.findAll();
      //pega a lista autores
      //cada item mapper.map(autor, AutorDto.class)
      //nova lista atualizada com os elementos

    return autores.stream()
                  .map(a -> mapper.map(a, AutorDto.class))
                  .collect(Collectors.toList()); 
  }

  @Override
  public Optional<AutorDto> obterAutorPorId(String id) {
    Optional<Autor> autor = autorRepository.findById(id);

    if (autor.isPresent()) {
      AutorDto dto = mapper.map(autor.get(), AutorDto.class);
      
      dto.setLivros(livroClient.obterLivrosPorAutor(id));

      return Optional.of(dto);
    }
    return Optional.empty();
  }

  @Override
  public void excluirAutor(String id) {
    autorRepository.deleteById(id);
    
  }

  @Override
  public AutorDto alterarAutor(String id, AutorDto autor) {
    Optional<Autor> autorBusca = autorRepository.findById(id);

    if (autorBusca.isPresent()) {
      Autor autorAlteracao = mapper.map(autor, Autor.class);
      autorAlteracao.setId(id);
      autorAlteracao = autorRepository.save(autorAlteracao);
      return mapper.map(autorAlteracao, AutorDto.class);
    }
   
    return null;
  }
  
}
