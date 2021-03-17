package com.vass.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.vass.demo.model.reclamo;

import com.vass.demo.service.reclamoService;

@RestController
public class reclamoController {

	@Autowired
	protected reclamoService reclamoservice;
	
	protected ObjectMapper objectMapper;
	//LISTAR TODOS LOS RECLAMOS
		@RequestMapping(value = "/ListarReclamos", method = RequestMethod.GET)
		public List<reclamo>ListarReclamos(){
			return reclamoservice.ListarReclamos();
		}
		
		//GUARDAR O ACTUALIZAR RECLAMO
		@RequestMapping(value = "/GuardarActualizarReclamo", method = RequestMethod.POST)
		public reclamo GuardaroActualizar(@RequestBody reclamo recl){		
			return reclamoservice.Guardar(recl);
		}
		
		//ELIMINAR
		@RequestMapping(value = "/EliminarReclamo", method = RequestMethod.POST)
		public void EliminarReclamo(@RequestBody String UserJSON) throws Exception{
			this.objectMapper = new ObjectMapper();
			reclamo recl = this.objectMapper.readValue(UserJSON, reclamo.class);
			if (Long.valueOf(recl.getIdReclamo())==null) {
				throw new Exception("EL CODIGO ID ES NULO");
			}
			reclamoservice.EliminarReclamo((long) recl.getIdReclamo());
		}

}
