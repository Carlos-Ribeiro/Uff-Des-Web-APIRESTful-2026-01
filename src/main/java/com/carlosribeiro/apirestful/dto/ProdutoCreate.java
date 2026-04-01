package com.carlosribeiro.apirestful.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Null;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ProdutoCreate(@Null Long id,
                            String imagem,
                            String nome,
                            String descricao,
                            boolean disponivel,
                            int qtdEstoque,
                            BigDecimal preco,
                            LocalDate dataCadastro,
                            @JsonProperty("categoria")
                            CategoriaResumo categoriaResumo) {
}
