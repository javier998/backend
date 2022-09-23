/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wcimbo.roles.controller;

import com.wcimbo.roles.entity.RolPago;
import com.wcimbo.roles.service.RolPagoService;
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
public class RolPagoController {
    @Autowired
    RolPagoService rolPago;
    
    @GetMapping("/roles-de-pago")
    public List<RolPago> ObtenerTodos(){
        return rolPago.GetAll();
    }
    
    @GetMapping("/rol-de-pago/{id}")
    public RolPago ObtenerPorId(@PathVariable(name="id") long id){
       return rolPago.GetById(id);
    }
    
    @PostMapping("/rol-de-pago")
    public ResponseEntity GuardarRol(@RequestBody RolPago request){
        rolPago.Post(request);
        return new ResponseEntity(HttpStatus.OK);
    }
    
    @PutMapping("rol-de-pago/{id}")
    public ResponseEntity ActualizarRol(@PathVariable (name = "id") long id, @RequestBody RolPago request ){
        rolPago.Put(request, id);
        return new ResponseEntity(HttpStatus.OK);
    }
    
    @DeleteMapping("rol-de-pago/{id}")
    public ResponseEntity EliminarRol(@PathVariable (name="id") long id){
        rolPago.Delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
