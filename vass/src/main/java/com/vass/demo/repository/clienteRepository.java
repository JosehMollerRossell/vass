package com.vass.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vass.demo.model.cliente;

public interface clienteRepository extends JpaRepository<cliente, Long> {

}
