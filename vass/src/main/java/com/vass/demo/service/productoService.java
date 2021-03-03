package com.vass.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import com.vass.demo.model.producto;

import com.vass.demo.repository.productoRepository;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
public class productoService {
	@Autowired
	public productoRepository productoRepositori;
	
	public List<producto>ListarProductos(){
		return productoRepositori.findAll();
	}
	
	public Optional<producto>BuscarPorId(Long id){
		return productoRepositori.findById(id);
	}
	
	public producto Guardar(producto produc) {
		
		return productoRepositori.save(produc);
	}
	
	public void EliminarProducto(Long id) {
		productoRepositori.deleteById(id);
	}
}
