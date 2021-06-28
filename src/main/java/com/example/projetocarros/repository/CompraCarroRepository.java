package com.example.projetocarros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.projetocarros.entity.CompraCarro;


@Repository
public interface CompraCarroRepository extends JpaRepository<CompraCarro, Long> {

}
