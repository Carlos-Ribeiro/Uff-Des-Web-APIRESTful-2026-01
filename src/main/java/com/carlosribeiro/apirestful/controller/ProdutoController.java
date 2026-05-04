package com.carlosribeiro.apirestful.controller;

import com.carlosribeiro.apirestful.dto.ProdutoCreate;
import com.carlosribeiro.apirestful.dto.ProdutoDto;
import com.carlosribeiro.apirestful.dto.ResultadoPaginado;
import com.carlosribeiro.apirestful.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:5173")
@RestController
@RequestMapping("produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    // http://localhost:8080/produtos
    @GetMapping
    public List<ProdutoDto> recuperarProdutos() {
        return produtoService.recuperarProdutos();
    }

    // http://localhost:8080/produtos/1
    @GetMapping("{idProduto}")
    public ProdutoDto recuperarProdutoPorId(@PathVariable("idProduto") long id) {
        return produtoService.recuperarProdutoPorId(id);
    }

//    @GetMapping("{idProduto}")
//    public ResponseEntity<?> recuperarProdutoPorId(@PathVariable("idProduto") long id) {
//        try {
//            Produto produto = produtoService.recuperarProdutoPorId(id);
//            return new ResponseEntity(produto, HttpStatus.OK);
//        } catch(EntidadeNaoEncontradaException e) {
//            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
//        }
//    }

    @PostMapping
    public ProdutoDto cadastrarProduto(@RequestBody @Valid ProdutoCreate produtoCreate) {
        return produtoService.cadastrarProduto(produtoCreate);
    }

    @PutMapping
    public ProdutoDto alterarProduto(@RequestBody ProdutoDto produto) {
        return produtoService.alterarProduto(produto);
    }

    // http://localhost:8080/produtos/1
    @DeleteMapping("{idProduto}")
    public void removerProdutoPotId(@PathVariable("idProduto") long id) {
        produtoService.removerProdutoPorId(id);
    }

    // http://localhost:8080/produtos/paginacao?pagina=0&tamanho=3
    @GetMapping("paginacao")
    public ResultadoPaginado<ProdutoDto> recuperarProdutosComPaginacao(
        @RequestParam(name = "pagina", defaultValue = "0") int pagina,
        @RequestParam(name = "tamanho", defaultValue = "5") int tamanho
    ) {
        PageRequest pageRequest = PageRequest.of(pagina, tamanho);
        Page<ProdutoDto> page = produtoService.recuperarProdutosComPaginacao(pageRequest);
        return new ResultadoPaginado<>(
            page.getTotalElements(),
            page.getTotalPages(),
            page.getNumber(),
            page.getContent());
    }
}



