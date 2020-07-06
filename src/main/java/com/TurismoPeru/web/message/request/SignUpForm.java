package com.TurismoPeru.web.message.request;

import java.util.Set;

import javax.validation.constraints.*;

public class SignUpForm {
	@NotBlank
    @Size(max = 50)
    private String nombre;

    @NotBlank
    @Email
    @Size(max = 50)
    private String username;

    @NotBlank
    @Size(max = 50)
    private String apellido;
    
    private Set<String> role;
    
    @NotBlank
    @Size(max = 40)
    private String password;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public Set<String> getRole() {
    	return this.role;
    }
    
    public void setRole(Set<String> role) {
    	this.role = role;
    }
}