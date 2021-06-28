package com.example.projetocarros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.projetocarros.entity.Carros;

@Repository
public interface CarrosRepository extends JpaRepository<Carros, Long> {

}
