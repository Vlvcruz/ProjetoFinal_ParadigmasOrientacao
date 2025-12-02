package com.example.crud.service.impl;
import com.example.crud.dto.*; import com.example.crud.model.*;
import com.example.crud.exception.*; import com.example.crud.mapper.*;
import com.example.crud.repository.*; import com.example.crud.service.*;
import org.springframework.stereotype.Service;
import java.util.*; import java.util.stream.*;
@Service
public class ProdutoServiceImpl implements ProdutoService{
 private final ProdutoRepository repo;
 public ProdutoServiceImpl(ProdutoRepository r){this.repo=r;}
 public ProdutoDTO criar(ProdutoDTO d){ return ProdutoMapper.toDTO(repo.save(ProdutoMapper.toEntity(d))); }
 public ProdutoDTO atualizar(Long id, ProdutoDTO d){
  Produto p=repo.findById(id).orElseThrow(()->new ResourceNotFoundException("Produto não encontrado"));
  p.setNome(d.getNome()); p.setDescricao(d.getDescricao()); p.setPreco(d.getPreco());
  return ProdutoMapper.toDTO(repo.save(p));
 }
 public ProdutoDTO buscar(Long id){ return ProdutoMapper.toDTO(repo.findById(id).orElseThrow(()->new ResourceNotFoundException("Produto não encontrado"))); }
 public List<ProdutoDTO> listar(){ return repo.findAll().stream().map(ProdutoMapper::toDTO).collect(Collectors.toList()); }
 public void deletar(Long id){ if(!repo.existsById(id)) throw new ResourceNotFoundException("Produto não encontrado"); repo.deleteById(id); }
}