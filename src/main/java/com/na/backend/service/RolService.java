package com.na.backend.service;

import java.util.List;

import com.na.backend.model.Rol;

public interface RolService {

    public Rol registrar(Rol roles);

    List<Rol> listarTodos();
}
