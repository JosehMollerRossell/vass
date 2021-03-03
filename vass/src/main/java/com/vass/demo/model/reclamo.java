package com.vass.demo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class reclamo implements Serializable{
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int idReclamo;
	private String motivoReclamo;
	private String descripcionReclamo;
	public int getIdReclamo() {
		return idReclamo;
	}
	public void setIdReclamo(int idReclamo) {
		this.idReclamo = idReclamo;
	}
	public String getMotivoReclamo() {
		return motivoReclamo;
	}
	public void setMotivoReclamo(String motivoReclamo) {
		this.motivoReclamo = motivoReclamo;
	}
	public String getDescripcionReclamo() {
		return descripcionReclamo;
	}
	public void setDescripcionReclamo(String descripcionReclamo) {
		this.descripcionReclamo = descripcionReclamo;
	}
	public reclamo(int idReclamo, String motivoReclamo, String descripcionReclamo) {
		super();
		this.idReclamo = idReclamo;
		this.motivoReclamo = motivoReclamo;
		this.descripcionReclamo = descripcionReclamo;
	}
	public reclamo() {
		super();
	} 
	
	
}
