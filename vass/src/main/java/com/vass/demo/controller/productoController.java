package com.vass.demo.controller;

import java.util.List;

import com.vass.demo.model.reclamo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

	@RequestMapping(value = "/EliminarProducto", method = RequestMethod.POST)
	public void EliminarReclamo(@RequestBody String UserJSON) throws Exception{
		this.objectMapper = new ObjectMapper();
		producto product = this.objectMapper.readValue(UserJSON, producto.class);
		if (Long.valueOf(product.getIdProducto())==null) {
			throw new Exception("EL CODIGO ID ES NULO");
		}
		productoservice.EliminarProducto((long) product.getIdProducto());
	}

}
