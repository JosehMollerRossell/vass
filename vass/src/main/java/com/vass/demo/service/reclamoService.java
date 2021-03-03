package com.vass.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import com.vass.demo.model.reclamo;

import com.vass.demo.repository.reclamoRepository;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
public class reclamoService {

	@Autowired
	public reclamoRepository reclamoRepositori;
	
	public List<reclamo>ListarReclamos(){
		return reclamoRepositori.findAll();
	}
	
	public Optional<reclamo>BuscarPorId(Long id){
		return reclamoRepositori.findById(id);
	}
	
	public reclamo Guardar(reclamo recl) {
		
		return reclamoRepositori.save(recl);
	}
	
	public void EliminarReclamo(Long id) {
		reclamoRepositori.deleteById(id);
	}
}
