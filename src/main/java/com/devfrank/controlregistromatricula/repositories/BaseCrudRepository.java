package com.devfrank.controlregistromatricula.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseCrudRepository<T, ID> extends JpaRepository<T, ID> {
}
