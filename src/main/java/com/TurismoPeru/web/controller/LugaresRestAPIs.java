package com.TurismoPeru.web.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TurismoPeru.web.entitys.Lugares;
import com.TurismoPeru.web.repository.LugaresRepository;

@RestController
@RequestMapping("/api/test/lugares")
public class LugaresRestAPIs {
	
	@Autowired
	private LugaresRepository lugaresRepository;
	
	@GetMapping
	public ResponseEntity<List<Lugares>>getLugares(){
		List<Lugares> lugares=lugaresRepository.findAll();
	    return ResponseEntity.ok(lugares);
	}
	
	@RequestMapping(value="{lugaresId}")// /buscar valor en el postman o url -> usuario/1
	public ResponseEntity<Lugares>getLugaresID(@PathVariable("lugaresId")Long lugaresId){
		Optional<Lugares> optionalLugares=lugaresRepository.findById(lugaresId);
		if(optionalLugares.isPresent()) {
			return ResponseEntity.ok(optionalLugares.get());
		}
	    	return ResponseEntity.noContent().build();	
	}
	
	@PostMapping //Insertar valor en el postman con "POST"
	public ResponseEntity<Lugares> createLugares(@RequestBody Lugares lugares){
		Lugares newLugares=lugaresRepository.save(lugares);
		return ResponseEntity.ok(newLugares);
	}
	
	@DeleteMapping(value="{lugaresId}") //Borrar dato en el postman con "DELETE" -> usuario/"id"
	public ResponseEntity<Void> deleteLugares(@PathVariable("lugaresId")Long lugaresId){
		lugaresRepository.deleteById(lugaresId);
		return ResponseEntity.ok(null);
	}
	
	@PutMapping //Actualizar el nombre del usuario con "PUT"
	public ResponseEntity<Lugares> updateLugares(@RequestBody Lugares lugares ){
		Optional<Lugares> optionalLugares=lugaresRepository.findById(lugares.getId());
		if(optionalLugares.isPresent()) {
			Lugares updateLugares=optionalLugares.get();
			updateLugares.setNombre(lugares.getNombre());
			updateLugares.setImagen(lugares.getImagen());
			lugaresRepository.save(updateLugares);
			return ResponseEntity.ok(updateLugares);
			
		}else {
			return ResponseEntity.notFound().build();
		}
	}

}
