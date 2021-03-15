package com.vass.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import com.vass.demo.model.cliente;
import com.vass.demo.repository.clienteRepository;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
public class clienteService {

	@Autowired
	public clienteRepository clienteRepositori;
	
	public List<cliente>ListarClientes(){
		return clienteRepositori.findAll();
	}
	
	public Optional<cliente> BuscarPorId(Long id){
		return clienteRepositori.findById(id);
	}
	
	public cliente Guardar(cliente client) {
		return clienteRepositori.save(client);
	}


	public void EliminarCliente(Long id) {
		 clienteRepositori.deleteById(id);
	}
	

}
