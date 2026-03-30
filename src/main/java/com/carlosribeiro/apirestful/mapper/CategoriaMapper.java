package com.carlosribeiro.apirestful.mapper;

import com.carlosribeiro.apirestful.dto.CategoriaResumo;
import com.carlosribeiro.apirestful.model.Categoria;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {

    // CategoriaResumo toCategoriaResumo(Categoria categoria);
}
