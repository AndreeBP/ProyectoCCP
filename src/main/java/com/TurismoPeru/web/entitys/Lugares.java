package com.TurismoPeru.web.entitys;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "lugares")
public class Lugares {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@Size(min=3, max = 50)
	private String nombre;
	
	@Size(max = 200)
	private String imagen;
	
	private int puntuacion;
	
	@Size(min=3, max = 200)
	private String predescripcion;
	
	@Size(min=3, max = 1000)
	private String descripcion;
	
	@Size(min=3, max = 200)
	private String direccion;
	
	@Size(min=3, max = 50)
	private String horario;
	

	@Override
	public String toString() {
		return "Lugares [id=" + id + ", nombre=" + nombre + ", imagen=" + imagen + ", puntuacion=" + puntuacion
				+ ", predescripcion=" + predescripcion + ", descripcion=" + descripcion + ", direccion=" + direccion
				+ ", horario=" + horario + "]";
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public int getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}

	public String getPredescripcion() {
		return predescripcion;
	}

	public void setPredescripcion(String predescripcion) {
		this.predescripcion = predescripcion;
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

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	
	


}
