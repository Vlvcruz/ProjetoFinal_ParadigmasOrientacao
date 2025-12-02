package com.example.crud.mapper;

import com.example.crud.dto.ProdutoDTO;
import com.example.crud.model.Produto;
import org.springframework.stereotype.Component;

@Component
public class ProdutoMapper {

    public static Produto toEntity(ProdutoDTO dto) {
        Produto p = new Produto();
        p.setNome(dto.getNome());
        p.setDescricao(dto.getDescricao());
        p.setPreco(dto.getPreco());
        return p;
    }

    public static ProdutoDTO toDTO(Produto p) {
        return new ProdutoDTO(
                p.getId(),
                p.getNome(),
                p.getDescricao(),
                p.getPreco()
        );
    }
}
