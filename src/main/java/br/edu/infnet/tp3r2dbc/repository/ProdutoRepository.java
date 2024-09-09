package br.edu.infnet.tp3r2dbc.repository;

import br.edu.infnet.tp3r2dbc.model.Produto;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface ProdutoRepository extends ReactiveCrudRepository<Produto, Long> {
    Flux<Produto> findByNomeContaining(String nome);
}
