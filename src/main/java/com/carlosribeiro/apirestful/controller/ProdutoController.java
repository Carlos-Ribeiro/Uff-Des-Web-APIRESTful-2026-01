package com.carlosribeiro.apirestful.controller;

import com.carlosribeiro.apirestful.model.Produto;
import com.carlosribeiro.apirestful.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<Produto> recuperarProdutos() {
        return produtoService.recuperarProduos();
    }
}
