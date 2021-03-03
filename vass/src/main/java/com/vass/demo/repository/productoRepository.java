package com.vass.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.vass.demo.model.producto;

public interface productoRepository extends JpaRepository<producto, Long> {

}
