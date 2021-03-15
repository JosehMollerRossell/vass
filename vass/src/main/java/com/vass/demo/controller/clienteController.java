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
		@RequestMapping(value = "/listar-clientes", method = RequestMethod.GET)
		public List<cliente>ListarUsuarios(){
			return clienteservice.ListarClientes();
		}
		
		//GUARDAR  CLIENTE sin idempotencia
		@RequestMapping(value = "/guardar", method = RequestMethod.POST)
		public cliente GuardaroActualizar(@RequestBody cliente client){		
			return clienteservice.Guardar(client);
		}
		

		//actualizar
		/*@RequestMapping(value = "/eliminar-cliente", method = RequestMethod.POST)
		public void EliminarProducto(@RequestBody String UserJSON) throws Exception{
			this.objectMapper = new ObjectMapper();
			producto produc = this.objectMapper.readValue(UserJSON, producto.class);
			clienteservice.EliminarCliente((long) produc.getIdProducto());
		}*/

		@RequestMapping(value = "/delete-client/{id}", method = RequestMethod.DELETE)
		public void getCliente(@PathVariable("id")Long id){
			  clienteservice.EliminarCliente(id);
		}
		   
}
