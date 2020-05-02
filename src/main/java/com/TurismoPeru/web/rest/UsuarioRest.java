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

import com.TurismoPeru.web.DAO.UsuarioDAO;
import com.TurismoPeru.web.entitys.Usuario;

@RestController
@RequestMapping("usuario")
public class UsuarioRest {
	
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@GetMapping
	public ResponseEntity<List<Usuario>>getUsuario(){
		List<Usuario> usuario=usuarioDAO.findAll();
	    return ResponseEntity.ok(usuario);
		
	}
	
	
	@RequestMapping(value="{usuarioId}")// /buscar valor en el postman o url -> usuario/1
	public ResponseEntity<Usuario>getUsuarioID(@PathVariable("usuarioId")Long usuarioId){
		Optional<Usuario> optionalUsuario=usuarioDAO.findById(usuarioId);
		if(optionalUsuario.isPresent()) {
			return ResponseEntity.ok(optionalUsuario.get());
		}
	    	return ResponseEntity.noContent().build();
		
	}
	
	@PostMapping //Insertar valor en el postman con "POST"
	public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario){
		Usuario newUsuario=usuarioDAO.save(usuario);
		return ResponseEntity.ok(newUsuario);
	}
	
	@DeleteMapping(value="{usuarioId}") //Borrar dato en el postman con "DELETE" -> usuario/"id"
	public ResponseEntity<Void> deleteUsuario(@PathVariable("usuarioId")Long usuarioId){
		usuarioDAO.deleteById(usuarioId);
		return ResponseEntity.ok(null);
	}
	
	@PutMapping //Actualizar el nombre del usuario con "PUT"
	public ResponseEntity<Usuario> updateUsuario(@RequestBody Usuario usuario ){
		Optional<Usuario> optionalUsuario=usuarioDAO.findById(usuario.getId());
		if(optionalUsuario.isPresent()) {
			Usuario updateUsuario=optionalUsuario.get();
			updateUsuario.setName(usuario.getName());
			usuarioDAO.save(updateUsuario);
			return ResponseEntity.ok(updateUsuario);
			
		}else {
			return ResponseEntity.notFound().build();
		}
	    	
	}

}