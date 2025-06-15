package com.na.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.na.backend.model.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, String> {
    // Metodo para buscar un login por su username
    Login findByUsername(String username);
    // Metodo para buscar un login por su email
    Login findByCorreo(String email);
    // Metodo para buscar telefono por su telefono
    Login findByTelefono(String telefono);
 

}
