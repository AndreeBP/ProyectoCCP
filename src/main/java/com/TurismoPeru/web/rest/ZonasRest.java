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

import com.TurismoPeru.web.DAO.ZonasDAO;

import com.TurismoPeru.web.entitys.Zonas;

@RestController
@RequestMapping("zonas")
public class ZonasRest {
	
	@Autowired
	private ZonasDAO zonasDAO;
	
	@GetMapping
	public ResponseEntity<List<Zonas>>getZonas(){
		List<Zonas> zonas=zonasDAO.findAll();
	    return ResponseEntity.ok(zonas);
	}
	
	@RequestMapping(value="{zonasId}")// /buscar valor en el postman o url -> usuario/1
	public ResponseEntity<Zonas>getZonasID(@PathVariable("zonasId")Long zonasId){
		Optional<Zonas> optionalZonas=zonasDAO.findById(zonasId);
		if(optionalZonas.isPresent()) {
			return ResponseEntity.ok(optionalZonas.get());
		}
	    	return ResponseEntity.noContent().build();	
	}
	
	@PostMapping //Insertar valor en el postman con "POST"
	public ResponseEntity<Zonas> createZonas(@RequestBody Zonas zonas){
		Zonas newZonas=zonasDAO.save(zonas);
		return ResponseEntity.ok(newZonas);
	}
	
	@DeleteMapping(value="{zonasId}") //Borrar dato en el postman con "DELETE" -> usuario/"id"
	public ResponseEntity<Void> deleteZonas(@PathVariable("zonasId")Long zonasId){
		zonasDAO.deleteById(zonasId);
		return ResponseEntity.ok(null);
	}
	
	@PutMapping //Actualizar el nombre del usuario con "PUT"
	public ResponseEntity<Zonas> updateZonas(@RequestBody Zonas zonas ){
		Optional<Zonas> optionalZonas=zonasDAO.findById(zonas.getIdZona());
		if(optionalZonas.isPresent()) {
			Zonas updateZonas=optionalZonas.get();
			updateZonas.setNombre(zonas.getNombre());
			zonasDAO.save(updateZonas);
			return ResponseEntity.ok(updateZonas);
			
		}else {
			return ResponseEntity.notFound().build();
		}
	}
}
