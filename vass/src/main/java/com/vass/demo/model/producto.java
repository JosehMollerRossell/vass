package com.vass.demo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class producto implements Serializable{

private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int idProducto;
	
	private String nombreProducto;	
	private String tecnologiaProducto;
	public int getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public String getTecnologiaProducto() {
		return tecnologiaProducto;
	}
	public void setTecnologiaProducto(String tecnologiaProducto) {
		this.tecnologiaProducto = tecnologiaProducto;
	}
	public producto(int idProducto, String nombreProducto, String tecnologiaProducto) {
		super();
		this.idProducto = idProducto;
		this.nombreProducto = nombreProducto;
		this.tecnologiaProducto = tecnologiaProducto;
	}
	public producto() {
		super();
	}
	
	
}
