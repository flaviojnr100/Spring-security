package com.flavio.seguranca.controller;

import com.flavio.seguranca.dataForm.UserRoleForm;
import com.flavio.seguranca.model.Role;
import com.flavio.seguranca.model.Usuario;
import com.flavio.seguranca.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/api")
@RequiredArgsConstructor
public class ControllerUser {

    private final UserService userService;

    @PostMapping("/user")
    public ResponseEntity<Usuario> save(@RequestBody Usuario usuario){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role").toUriString());
        return ResponseEntity.created(uri).body(userService.save(usuario));
    }
    @GetMapping("/users")
    public ResponseEntity<List<Usuario>> fetchUsers(){
        return ResponseEntity.ok().body(userService.fetchUsers());
    }

    @PostMapping("/role")
    public ResponseEntity<Role> saveRole(@RequestBody Role role){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role").toUriString());
        return ResponseEntity.created(uri).body(userService.saveRole(role));
    }

    @GetMapping("/roles")
    public ResponseEntity<List<Role>> fetchRoles(){
        return ResponseEntity.ok().body(userService.fetchRoles());
    }

    @PostMapping("role/addUser")
    public ResponseEntity<?>addRoleToUser(@RequestBody UserRoleForm userRoleForm){
        userService.addRole(userRoleForm.getEmail(),userRoleForm.getRoleName());
        return ResponseEntity.ok().build();

    }

}
