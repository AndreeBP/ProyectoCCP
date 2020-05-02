package com.TurismoPeru.web.entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="admin")
public class Admin {
	
	@Id
	@Column(name="idAdmin")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idAdmin;
	
	@Column(name="nombre", nullable=false)
	private String nombre;
	
	@Column(name="contraseña", nullable=false)
	private String contraseña;

	public Long getIdAdmin() {
		return idAdmin;
	}

	public void setIdAdmin(Long idAdmin) {
		this.idAdmin = idAdmin;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	
	
	

}
