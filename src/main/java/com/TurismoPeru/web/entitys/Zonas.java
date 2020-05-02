package com.TurismoPeru.web.entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="zonas")
public class Zonas {
	
	@Id
	@Column(name="idZona")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idZona;
	
	@Column(name="nombre", nullable=false)
	private String nombre;
	
	@Column(name="descripcion", nullable=false)
	private String descripcion;
	
	@Column(name="direccion", nullable=false)
	private String direccion;

	
	public Long getIdZona() {
		return idZona;
	}

	public void setIdZona(Long idZona) {
		this.idZona = idZona;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	

}
