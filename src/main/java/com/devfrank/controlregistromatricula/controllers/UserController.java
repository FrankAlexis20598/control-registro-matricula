package com.devfrank.controlregistromatricula.controllers;

import com.devfrank.controlregistromatricula.models.UserDTO;
import com.devfrank.controlregistromatricula.services.IUserService;
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
@RequestMapping("/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final IUserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() throws Exception {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Integer id) throws Exception {
        return ResponseEntity.ok(userService.findById(id));
    }

    @PostMapping
    public ResponseEntity<UserDTO> create(@Valid @RequestBody UserDTO userDTO) throws Exception {
        return ResponseEntity.ok(userService.create(userDTO));
    }

    /**
     * BLOQUEADO: El uso de 'username' como claim principal causa UsernameNotFoundException
     * si el usuario cambia sus datos o se borra, ya que el token actual queda huérfano.
     * Sin lógica de Refresh Token, la app queda en estado inconsistente (Crash).
     */
    @PreAuthorize("denyAll()")
    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> update(@PathVariable Integer id, @Valid @RequestBody UserDTO userDTO) throws Exception {
        return ResponseEntity.ok(userService.update(id, userDTO));
    }

    /**
     * BLOQUEADO: El uso de 'username' como claim principal causa UsernameNotFoundException
     * si el usuario cambia sus datos o se borra, ya que el token actual queda huérfano.
     * Sin lógica de Refresh Token, la app queda en estado inconsistente (Crash).
     */
    @PreAuthorize("denyAll()")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
