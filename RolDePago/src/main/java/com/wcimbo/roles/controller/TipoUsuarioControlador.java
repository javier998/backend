/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wcimbo.roles.controller;

import com.wcimbo.roles.entity.TipoUsuario;
import com.wcimbo.roles.service.TipoUsuarioService;
import com.wcimbo.roles.utils.exceptions.RequestException;
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

public class TipoUsuarioControlador {
    
    @Autowired
    TipoUsuarioService tipoUsuarioService;
    
    @GetMapping("/tipos-usuarios")
    public List<TipoUsuario> ObtenerTiposUusarios(){
        return tipoUsuarioService.GetAll();
    }
    
    @GetMapping("/tipo-usuario/{id}")
    public TipoUsuario ObtenerTipoPorId(@PathVariable(name="id") long id){
       return tipoUsuarioService.GetById(id);
    }
    
    @PostMapping("/tipo-usuario")
    public ResponseEntity GuardarTipoUsuario(@RequestBody TipoUsuario request){
        tipoUsuarioService.Post(request);
        return new ResponseEntity(HttpStatus.OK);
    }
    
    @PutMapping("tipo-usuario/{id}")
    public ResponseEntity ActualizarTipoUsuario(@PathVariable (name = "id") long id, @RequestBody TipoUsuario request ){
        tipoUsuarioService.Put(request, id);
        return new ResponseEntity(HttpStatus.OK);
    }
    
    @DeleteMapping("tipo-usuario/{id}")
    public ResponseEntity EliminarTipoUsuario(@PathVariable (name="id") long id){
        tipoUsuarioService.DeleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
