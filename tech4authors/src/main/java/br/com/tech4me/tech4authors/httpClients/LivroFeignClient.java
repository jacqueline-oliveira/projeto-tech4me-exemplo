package br.com.tech4me.tech4authors.httpClients;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.tech4me.tech4authors.shared.Livro;

@FeignClient(name="tech4books", fallback = LivroFeignClientFallback.class)
public interface LivroFeignClient {
  @GetMapping(path= "/api/livros/autor/{autor}")
  List<Livro> obterLivrosPorAutor(@PathVariable String autor);
}

@Component
class LivroFeignClientFallback implements LivroFeignClient {

  @Override
  public List<Livro> obterLivrosPorAutor(String autor) {
    return new ArrayList<>();
  }

}
