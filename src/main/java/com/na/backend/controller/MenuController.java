package com.na.backend.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.na.backend.message.MenuMessage;
import com.na.backend.message.SeguridadMessage;
import com.na.backend.model.Menu;
import com.na.backend.model.Rol;
import com.na.backend.repository.RolRepository;
import com.na.backend.service.MenuService;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;
    @Autowired
    private RolRepository rolRepository; // Inyectamos el repositorio de Rol

    @GetMapping("/listaRolesCodigo/{rolCodigoPrimero}/{rolCodigoSegundo}")
    public ResponseEntity<?> obtenerMenusPorDosRoles(@PathVariable String rolCodigoPrimero,
            @PathVariable String rolCodigoSegundo) {
        try {
            // Buscar los roles en la base de datos
            Rol PrimerRol = rolRepository.findByCodigo(rolCodigoPrimero);
            Rol SegundoRol = rolRepository.findByCodigo(rolCodigoSegundo);

            // Validar si ambos roles existen
            if (PrimerRol == null || SegundoRol == null) {
                String mensaje = (PrimerRol == null ? rolCodigoPrimero : "") +
                        (SegundoRol == null ? rolCodigoSegundo : "");
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(MenuMessage.ROL_NO_ENCONTRADO.getMensaje() + mensaje.trim());
            }

            // Obtener menús para ambos roles
            List<Menu> listadoPrimerRol = menuService.obtenerMenusPorRol(PrimerRol);
            List<Menu> listadoSegundoRol = menuService.obtenerMenusPorRol(SegundoRol);

            // Fusionar y evitar duplicados (opcional)
            List<Menu> todosLosMenus = new ArrayList<>(listadoPrimerRol);
            todosLosMenus.addAll(listadoSegundoRol);

            // Validar si hay menús
            if (todosLosMenus.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(MenuMessage.MENU_ROLES.getMensaje() + rolCodigoPrimero + " y " + rolCodigoSegundo);
            }

            // Retornar menús encontrados
            return ResponseEntity.ok(todosLosMenus);

        } catch (Exception e) {
            e.printStackTrace();
            // Manejo de excepciones generales
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(SeguridadMessage.ERROR_INTERNO.getMensaje());
        }
    }

    @GetMapping("/listar/PrimerNivel")
    public ResponseEntity<List<Menu>> menuPrimero() {
        List<Menu> menuPrimero = menuService.menuPrimero();
        return ResponseEntity.ok(menuPrimero);
    }

    @GetMapping("/listar/SegundoNivel")
    public ResponseEntity<List<Menu>> menuSegundo() {
        List<Menu> menuSegundo = menuService.menuSegundo();
        return ResponseEntity.ok(menuSegundo);
    }

    @GetMapping("/listar/TercerNivel")
    public ResponseEntity<List<Menu>> menuTercero() {
        List<Menu> menuSegundo = menuService.menuTercero();
        return ResponseEntity.ok(menuSegundo);
    }
}
