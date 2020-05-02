package com.TurismoPeru.web.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TurismoPeru.web.entitys.Usuario;

public interface UsuarioDAO extends JpaRepository<Usuario, Long>{

}
