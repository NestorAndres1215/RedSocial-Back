package com.na.backend.service;

import java.util.List;

import com.na.backend.model.Menu;
import com.na.backend.model.Rol;

public interface MenuService {
    
    List<Menu> obtenerMenusPorRol(Rol rol);

    List<Menu> menuPrimero();

    List<Menu> menuSegundo();

    List<Menu> menuTercero();

}