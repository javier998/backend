/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wcimbo.roles.controller;

import com.wcimbo.roles.entity.Transaccion;
import com.wcimbo.roles.service.TransaccionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author javi_
 */
@RestController
public class TransaccionController {
    @Autowired
    TransaccionService transaccion;
    
    @GetMapping("/transacciones")
    public List<Transaccion> ObtenerTodos(){
        return transaccion.GetAll();
    }
    
    @GetMapping("/transaccion/{id}")
    public Transaccion ObtenerPorId(@PathVariable(name="id") long id){
       return transaccion.GetById(id);
    }
    
    @PostMapping("/transaccion")
    public ResponseEntity GuardarTransaccion(@RequestBody Transaccion request){
        transaccion.Post(request);
        return new ResponseEntity(HttpStatus.OK);
    }
    
    @PutMapping("transaccion/{id}")
    public ResponseEntity ActualizarRol(@PathVariable (name = "id") long id, @RequestBody Transaccion request ){
        transaccion.Put(request, id);
        return new ResponseEntity(HttpStatus.OK);
    }
    
    @DeleteMapping("transaccion/{id}")
    public ResponseEntity EliminarRol(@PathVariable (name="id") long id){
        transaccion.Delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
