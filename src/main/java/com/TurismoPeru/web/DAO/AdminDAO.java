package com.TurismoPeru.web.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TurismoPeru.web.entitys.Admin;

public interface AdminDAO extends JpaRepository<Admin, Long>{

}
