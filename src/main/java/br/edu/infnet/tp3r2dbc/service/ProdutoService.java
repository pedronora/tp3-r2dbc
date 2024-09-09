package br.edu.infnet.tp3r2dbc.service;

import br.edu.infnet.tp3r2dbc.model.Produto;
import br.edu.infnet.tp3r2dbc.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ProdutoService {
    private final ProdutoRepository produtoRepository;

    public Mono<Produto> create(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Flux<Produto> getAll() {
        return produtoRepository.findAll();
    }

    public Mono<Produto> getById(Long id) {
        return produtoRepository.findById(id);
    }

    public Mono<Produto> update(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Mono<Void> deleteById(Long id) {
        return produtoRepository.deleteById(id);
    }
}
