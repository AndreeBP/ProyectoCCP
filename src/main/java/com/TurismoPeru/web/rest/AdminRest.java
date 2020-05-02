package com.TurismoPeru.web.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TurismoPeru.web.DAO.AdminDAO;
import com.TurismoPeru.web.entitys.Admin;



@RestController
@RequestMapping("admin")
public class AdminRest {
	
	@Autowired
	private AdminDAO adminDAO;
	
	@GetMapping
	public ResponseEntity<List<Admin>>getAdmin(){
		List<Admin> admin=adminDAO.findAll();
	    return ResponseEntity.ok(admin);
	}
	
	@RequestMapping(value="{adminId}")// /buscar valor en el postman -> admin/1
	public ResponseEntity<Admin>getAdminID(@PathVariable("adminId")Long adminId){
		Optional<Admin> optionalAdmin=adminDAO.findById(adminId);
		if(optionalAdmin.isPresent()) {
			return ResponseEntity.ok(optionalAdmin.get());
		}
	    	return ResponseEntity.noContent().build();
	}
	
	@PostMapping //Insertar valor en el postman con "POST"
	public ResponseEntity<Admin> createAdmin(@RequestBody Admin admin){
		Admin newAdmin=adminDAO.save(admin);
		return ResponseEntity.ok(newAdmin);
	}
	
	@DeleteMapping(value="{adminId}") //Borrar dato en el postman con "DELETE" -> admin/"id"
	public ResponseEntity<Void> deleteAdmin(@PathVariable("adminId")Long adminId){
		adminDAO.deleteById(adminId);
		return ResponseEntity.ok(null);
	}
	
	@PutMapping //Actualizar el admin con "PUT"
	public ResponseEntity<Admin> updateAdmin(@RequestBody Admin admin ){
		Optional<Admin> optionalAdmin=adminDAO.findById(admin.getIdAdmin());
		if(optionalAdmin.isPresent()) {
			Admin updateAdmin=optionalAdmin.get();
			updateAdmin.setNombre(admin.getNombre());
			adminDAO.save(updateAdmin);
			return ResponseEntity.ok(updateAdmin);
			
		}else {
			return ResponseEntity.notFound().build();
		}
	    	
	}


}
