package com.vass.demo.model;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class cliente implements Serializable{

private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int idCliente;
	
	private String tipoDocumento;	
	private String numeroDocumento;	
	private String nombreCliente;
	private String apellidoCliente;
	private Date fechaNacimiento;
	
	
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public String getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public String getNumeroDocumento() {
		return numeroDocumento;
	}
	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public String getApellidoCliente() {
		return apellidoCliente;
	}
	public void setApellidoCliente(String apellidoCliente) {
		this.apellidoCliente = apellidoCliente;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public cliente(int idCliente, String tipoDocumento, String numeroDocumento, String nombreCliente,
			String apellidoCliente, Date fechaNacimiento) {
		super();
		this.idCliente = idCliente;
		this.tipoDocumento = tipoDocumento;
		this.numeroDocumento = numeroDocumento;
		this.nombreCliente = nombreCliente;
		this.apellidoCliente = apellidoCliente;
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public cliente() {
		super();
	}
	
	private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof cliente)) {
            return false;
        }
        cliente that = (cliente) other;
        if (this.getIdCliente() != that.getIdCliente()) {
            return false;
        }
        return true;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof cliente)) return false;
        return this.equalKeys(other) && ((cliente)other).equalKeys(this);
    }

    @Override
    public int hashCode() {
        int i;
        int result = 17;
        i = getIdCliente();
        result = 37*result + i;
        return result;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("[cliente |");
        sb.append(" idCliente=").append(getIdCliente());
        sb.append("]");
        return sb.toString();
    }

    public Map<String, Object> getPrimaryKey() {
        Map<String, Object> ret = new LinkedHashMap<String, Object>(6);
        ret.put("idCliente", Integer.valueOf(getIdCliente()));
        return ret;
    }
}
