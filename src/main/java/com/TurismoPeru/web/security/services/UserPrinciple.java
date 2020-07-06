package com.TurismoPeru.web.security.services;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.TurismoPeru.web.entitys.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserPrinciple implements UserDetails {
	  private static final long serialVersionUID = 1L;
	 
	  private Long id;

	    private String nombre;

	    private String username;

	    private String apellido;

	    @JsonIgnore
	    private String password;

	    private Collection<? extends GrantedAuthority> authorities;

	    public UserPrinciple(Long id, String nombre, 
				    		String username, String apellido, String password, 
				    		Collection<? extends GrantedAuthority> authorities) {
	        this.id = id;
	        this.nombre = nombre;
	        this.username = username;
	        this.apellido = apellido;
	        this.password = password;
	        this.authorities = authorities;
	    }

	    public static UserPrinciple build(User user) {
	        List<GrantedAuthority> authorities = user.getRoles().stream().map(role ->
	                new SimpleGrantedAuthority(role.getName().name())
	        ).collect(Collectors.toList());

	        return new UserPrinciple(
	                user.getId(),
	                user.getNombre(),
	                user.getUsername(),
	                user.getApellido(),
	                user.getPassword(),
	                authorities
	        );
	    }

	    public Long getId() {
	        return id;
	    }

	    public String getNombre() {
	        return nombre;
	    }

	    public String getApellido() {
	        return apellido;
	    }

	    @Override
	    public String getUsername() {
	        return username;
	    }

	    @Override
	    public String getPassword() {
	        return password;
	    }

	    @Override
	    public Collection<? extends GrantedAuthority> getAuthorities() {
	        return authorities;
	    }

	    @Override
	    public boolean isAccountNonExpired() {
	        return true;
	    }

	    @Override
	    public boolean isAccountNonLocked() {
	        return true;
	    }

	    @Override
	    public boolean isCredentialsNonExpired() {
	        return true;
	    }

	    @Override
	    public boolean isEnabled() {
	        return true;
	    }

	    @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;
	        
	        UserPrinciple user = (UserPrinciple) o;
	        return Objects.equals(id, user.id);
	    }
}