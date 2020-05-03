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

import com.TurismoPeru.web.DAO.RegistrarDAO;
import com.TurismoPeru.web.entitys.Registrar;


@RestController
@RequestMapping("registrar")
public class RegistrarRest {
	
	@Autowired
	private RegistrarDAO registrarDAO;
	
	@GetMapping
	public ResponseEntity<List<Registrar>>getRegistrar(){
		List<Registrar> registrar=registrarDAO.findAll();
	    return ResponseEntity.ok(registrar);
		
	}
	
	
	@RequestMapping(value="{registrarId}")// /buscar valor en el postman o url -> usuario/1
	public ResponseEntity<Registrar>getRegistrarID(@PathVariable("registrarId")Long registrarId){
		Optional<Registrar> optionalRegistrar=registrarDAO.findById(registrarId);
		if(optionalRegistrar.isPresent()) {
			return ResponseEntity.ok(optionalRegistrar.get());
		}
	    	return ResponseEntity.noContent().build();
		
	}
	
	@PostMapping //Insertar valor en el postman con "POST"
	public ResponseEntity<Registrar> createRegistrar(@RequestBody Registrar registrar){
		Registrar newRegistrar=registrarDAO.save(registrar);
		return ResponseEntity.ok(newRegistrar);
	}
	
	@DeleteMapping(value="{registrarId}") //Borrar dato en el postman con "DELETE" -> registrar/"id"
	public ResponseEntity<Void> deleteRegistrar(@PathVariable("registrarId")Long registrarId){
		registrarDAO.deleteById(registrarId);
		return ResponseEntity.ok(null);
	}
	
	@PutMapping //Actualizar el registro con "PUT"
	public ResponseEntity<Registrar> updateRegistrar(@RequestBody Registrar registrar ){
		Optional<Registrar> optionalRegistrar=registrarDAO.findById(registrar.getId());
		if(optionalRegistrar.isPresent()) {
			Registrar updateRegistrar=optionalRegistrar.get();
			updateRegistrar.setName(registrar.getName());
			registrarDAO.save(updateRegistrar);
			return ResponseEntity.ok(updateRegistrar);
			
		}else {
			return ResponseEntity.notFound().build();
		}
	    	
	}

}