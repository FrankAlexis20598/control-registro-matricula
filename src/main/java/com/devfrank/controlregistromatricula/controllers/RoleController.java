package com.devfrank.controlregistromatricula.controllers;

import com.devfrank.controlregistromatricula.models.RoleDTO;
import com.devfrank.controlregistromatricula.services.IRoleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
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

import java.util.List;

@RestController
@RequestMapping("/v1/roles")
@RequiredArgsConstructor
public class RoleController {

    private final IRoleService roleService;

    @GetMapping
    public ResponseEntity<List<RoleDTO>> findAll() throws Exception {
        return ResponseEntity.ok(roleService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleDTO> findById(@PathVariable Integer id) throws Exception {
        return ResponseEntity.ok(roleService.findById(id));
    }

    @PostMapping
    public ResponseEntity<RoleDTO> create(@Valid @RequestBody RoleDTO roleDTO) throws Exception {
        return ResponseEntity.ok(roleService.create(roleDTO));
    }

    /**
     * BLOQUEADO: El uso de 'username' como claim principal causa UsernameNotFoundException
     * si el usuario cambia sus datos o se borra, ya que el token actual queda huérfano.
     * Lo mismo sucede al modificar un rol.
     * Sin lógica de Refresh Token, la app queda en estado inconsistente (Crash).
     */
    @PreAuthorize("denyAll()")
    @PutMapping("/{id}")
    public ResponseEntity<RoleDTO> update(@PathVariable Integer id, @Valid @RequestBody RoleDTO roleDTO) throws Exception {
        return ResponseEntity.ok(roleService.update(id, roleDTO));
    }

    /**
     * BLOQUEADO: El uso de 'username' como claim principal causa UsernameNotFoundException
     * si el usuario cambia sus datos o se borra, ya que el token actual queda huérfano.
     * Lo mismo sucede al modificar un rol.
     * Sin lógica de Refresh Token, la app queda en estado inconsistente (Crash).
     */
    @PreAuthorize("denyAll()")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {
        roleService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
