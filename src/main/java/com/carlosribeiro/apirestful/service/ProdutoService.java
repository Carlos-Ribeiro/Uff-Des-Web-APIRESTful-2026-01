package com.carlosribeiro.apirestful.service;

import com.carlosribeiro.apirestful.model.Produto;
import com.carlosribeiro.apirestful.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> recuperarProduos() {
        return produtoRepository.findAll();
    }
}
