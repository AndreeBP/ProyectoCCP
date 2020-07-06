package com.TurismoPeru.web.entitys;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "comentarios")
public class Comentario {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private Integer user_id;
	
	private Integer lugar_id;
	
	@Size(min=3, max = 500)
	private String comentario;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getUsers_id() {
		return user_id;
	}

	public void setUsers_id(Integer users_id) {
		this.user_id = users_id;
	}

	public Integer getLugar_id() {
		return lugar_id;
	}

	public void setLugar_id(Integer lugar_id) {
		this.lugar_id = lugar_id;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	@Override
	public String toString() {
		return "Comentario [id=" + id + ", users_id=" + user_id + ", publicaciones_id=" + lugar_id
				+ ", comentario=" + comentario + "]";
	}

}
