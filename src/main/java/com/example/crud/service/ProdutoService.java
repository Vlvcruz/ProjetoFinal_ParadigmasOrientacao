package com.example.crud.service;
import com.example.crud.dto.ProdutoDTO;
import java.util.*;
public interface ProdutoService{
 ProdutoDTO criar(ProdutoDTO d);
 ProdutoDTO atualizar(Long id, ProdutoDTO d);
 ProdutoDTO buscar(Long id);
 List<ProdutoDTO> listar();
 void deletar(Long id);
}