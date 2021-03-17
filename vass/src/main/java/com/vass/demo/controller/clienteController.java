package com.vass.demo.controller;

import java.util.List;

import com.vass.demo.model.producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.vass.demo.model.cliente;
//import com.fasterxml.jackson.databind.ObjectMapper;
import com.vass.demo.service.clienteService;

import io.swagger.models.Path;

@RestController
public class clienteController {

	@Autowired
	protected clienteService clienteservice;
	
	protected ObjectMapper objectMapper;
	//LISTAR TODOS LOS CLIENTES
		@RequestMapping(value = "/listarclientes", method = RequestMethod.GET)
		public List<cliente>ListarUsuarios(){
			return clienteservice.ListarClientes();
		}
		
		//GUARDAR  CLIENTE sin idempotencia
		@RequestMapping(value = "/guardarCliente", method = RequestMethod.POST)
		public cliente GuardaroActualizar(@RequestBody cliente client){		
			return clienteservice.Guardar(client);
		}


	@RequestMapping(value = "/EliminarCliente", method = RequestMethod.POST)
	public void EliminarCliente(@RequestBody String UserJSON) throws Exception{
		this.objectMapper = new ObjectMapper();
		cliente client = this.objectMapper.readValue(UserJSON, cliente.class);
		if (Long.valueOf(client.getIdCliente())==null) {
			throw new Exception("EL CODIGO ID ES NULO");
		}
		clienteservice.EliminarCliente((long) client.getIdCliente());
	}
		   
}
