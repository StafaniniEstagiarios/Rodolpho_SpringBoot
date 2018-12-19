package com.stefanini.estudo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GenericRepository<T> extends JpaRepository<T, Integer>{

}
