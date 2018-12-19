package com.stefanini.estudo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.stefanini.estudo.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

}
