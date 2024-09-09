package br.edu.infnet.tp3r2dbc.controller;

import br.edu.infnet.tp3r2dbc.model.Produto;
import br.edu.infnet.tp3r2dbc.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/produtos")
public class ProdutoController {
    private final ProdutoService produtoService;

    @PostMapping
    public Mono<Produto> create(@RequestBody Produto produto) {
        return produtoService.create(produto);
    }

    @GetMapping
    public Flux<Produto> getAll() {
        return produtoService.getAll();
    }

    @GetMapping("/{id}")
    public Mono<Produto> getById(@PathVariable Long id) {
        return produtoService.getById(id);
    }

    @PutMapping("/{id}")
    public Mono<Produto> update(@PathVariable Long id, @RequestBody Produto produto) {
        return produtoService.getById(id).flatMap(existingProduto -> {
            existingProduto.setNome(produto.getNome());
            existingProduto.setPreco(produto.getPreco());

            return produtoService.create(existingProduto);
        });
    }


    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable Long id) {
        return produtoService.deleteById(id);
    }
}
