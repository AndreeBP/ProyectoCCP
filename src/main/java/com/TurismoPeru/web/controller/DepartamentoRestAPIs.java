package com.TurismoPeru.web.controller;

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

import com.TurismoPeru.web.entitys.Departamento;
import com.TurismoPeru.web.repository.DepartamentoRepository;


@RestController
@RequestMapping("/api/test/departamentos")
public class DepartamentoRestAPIs {
	
	@Autowired
	private DepartamentoRepository departamentosRepository;
	
	@GetMapping
	public ResponseEntity<List<Departamento>>getNombre(){
		List<Departamento> departamento=departamentosRepository.findAll();
	    return ResponseEntity.ok(departamento);
	}
	
	@RequestMapping(value="{departamentoId}")
	public ResponseEntity<Departamento>getDepartamentoID(@PathVariable("departamentoId")Long departamentoId){
		Optional<Departamento> optionalDepartamento=departamentosRepository.findById(departamentoId);
		if(optionalDepartamento.isPresent()) {
			return ResponseEntity.ok(optionalDepartamento.get());
		}
	    	return ResponseEntity.noContent().build();	
	}
	
	@PostMapping
	public ResponseEntity<Departamento> createDepartamento(@RequestBody Departamento departamento){
		Departamento newDepartamento=departamentosRepository.save(departamento);
		return ResponseEntity.ok(newDepartamento);
	}
	
	@DeleteMapping(value="{departamentoId}") 
	public ResponseEntity<Void> deleteDepartamento(@PathVariable("departamentoId")Long departamentoId){
		departamentosRepository.deleteById(departamentoId);
		return ResponseEntity.ok(null);
	}
	
	@PutMapping
	public ResponseEntity<Departamento> updateDepartamento(@RequestBody Departamento departamento ){
		Optional<Departamento> optionalDepartamento=departamentosRepository.findById(departamento.getId());
		if(optionalDepartamento.isPresent()) {
			Departamento updateDepartamento=optionalDepartamento.get();
			updateDepartamento.setNombre(departamento.getNombre());
			updateDepartamento.setImagen(departamento.getImagen());
			updateDepartamento.setDescripcion(departamento.getDescripcion());
			departamentosRepository.save(updateDepartamento);
			return ResponseEntity.ok(updateDepartamento);
			
		}else {
			return ResponseEntity.notFound().build();
		}
	}

}
