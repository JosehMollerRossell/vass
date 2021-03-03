package com.vass.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vass.demo.model.producto;
import com.vass.demo.service.productoService;

@RestController
public class productoController {
	@Autowired
	protected productoService productoservice;
	
	protected ObjectMapper objectMapper;
	//LISTAR TODOS LOS PRODUCTOS
		@RequestMapping(value = "/ListarProductos", method = RequestMethod.GET)
		public List<producto>ListarProductos(){
			return productoservice.ListarProductos();
		}
		
		//GUARDAR O ACTUALIZAR PRODUC
		@RequestMapping(value = "/GuardarActualizarProd", method = RequestMethod.POST)
		public producto GuardaroActualizar(@RequestBody producto produc){		
			return productoservice.Guardar(produc);
		}
		
		//ELIMINAR
		@RequestMapping(value = "/EliminarProducto", method = RequestMethod.POST)
		public void EliminarProducto(@RequestBody String UserJSON) throws Exception{
			this.objectMapper = new ObjectMapper();
			producto produc = this.objectMapper.readValue(UserJSON, producto.class);
			if (Long.valueOf(produc.getIdProducto())==null) {
				throw new Exception("EL CODIGO ID ES NULO");			
			}
			productoservice.EliminarProducto((long) produc.getIdProducto());
			//clienteService.EliminarCliente((long) cliente.getIdUsuario());
		}
}
