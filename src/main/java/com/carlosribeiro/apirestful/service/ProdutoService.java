package com.carlosribeiro.apirestful.service;

import com.carlosribeiro.apirestful.dto.ProdutoCreate;
import com.carlosribeiro.apirestful.dto.ProdutoDto;
import com.carlosribeiro.apirestful.exception.EntidadeNaoEncontradaException;
import com.carlosribeiro.apirestful.mapper.ProdutoMapper;
import com.carlosribeiro.apirestful.model.Produto;
import com.carlosribeiro.apirestful.repository.ProdutoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ProdutoMapper produtoMapper;

    public List<ProdutoDto> recuperarProduos() {
        List<Produto> produtos = produtoRepository.recuperarProduos();
        return produtoMapper.toProdutosDto(produtos);
    }

    public ProdutoDto recuperarProdutoPorId(long id) {
        Produto produto = produtoRepository.findById(id)
            .orElseThrow(() -> new EntidadeNaoEncontradaException(
                "Produto com id = " + id + " não encontrado."));
        return produtoMapper.toProdutoDto(produto);
    }

    public ProdutoDto cadastrarProduo(ProdutoCreate produtoCreate) {
        Produto produto = produtoMapper.toProduto(produtoCreate);
        produto = produtoRepository.save(produto);
        return produtoMapper.toProdutoDto(produto);
    }

    public ProdutoDto alterarProduo(ProdutoDto produtoDto) {
        Produto produto = produtoMapper.toProduto(produtoDto);
        produto = produtoRepository.save(produto);
        return produtoMapper.toProdutoDto(produto);
    }

    public void removerProduoPorId(long id) {
        recuperarProdutoPorId(id);
        produtoRepository.deleteById(id);
    }
}
