/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wcimbo.roles.controller;

import com.wcimbo.roles.entity.Usuario;
import com.wcimbo.roles.service.PersonaService;
import com.wcimbo.roles.service.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author javi_
 */

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})

public class UsuarioController {
    
    @Autowired
    UsuarioService usuarioService;
    
    
    @GetMapping("/usuarios")
    public List<Usuario> ObtenerTodos(){
        return usuarioService.GetAll();
    }
    
    @GetMapping("/usuario/{username}")
    public Usuario ObtenerPorId(@PathVariable (value="username") String username){
        return usuarioService.GetByID(username);
    }
    
    
    
    @PostMapping("/usuario")
    public ResponseEntity GuardarUsuario(@RequestBody Usuario usuario){
        usuarioService.Post(usuario);
     return new ResponseEntity(HttpStatus.OK);
    }
    
    @PutMapping("/usuario/{username}")
    public ResponseEntity ActualizarUsuario(@PathVariable(value = "username")String username, @RequestBody Usuario usuario){
       usuarioService.Put(usuario, username);
     return new ResponseEntity(HttpStatus.OK);
    }
    
    @DeleteMapping("/usuario/{username}")
    public ResponseEntity EliminarUsuario(@PathVariable(value="username") String username){
        usuarioService.DeleteById(username);
     return new ResponseEntity(HttpStatus.OK);    
    }
    
    @PostMapping("auth/usuario/")
    public Usuario ObtenerToken(@RequestBody Usuario usuario){
        return usuarioService.Token(usuario);
    }
}
