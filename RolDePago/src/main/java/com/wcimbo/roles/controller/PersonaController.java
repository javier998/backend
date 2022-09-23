/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wcimbo.roles.controller;

import com.wcimbo.roles.entity.Persona;
import com.wcimbo.roles.service.PersonaService;
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
public class PersonaController {
    
    @Autowired
    PersonaService personaService;
    
    @GetMapping("/personas")
    public List<Persona> ObtenerPersonas(){
        return personaService.GetAll();
    }
    
    @GetMapping("/persona/{id}")
    public Persona ObtenerPersonaPorCedula(@PathVariable(value="id") String cedula){
        return personaService.GetById(cedula);
    }
    
   @PostMapping("/persona")
    public ResponseEntity GuardarPersona(@RequestBody Persona request){
        personaService.Post(request);
        return new ResponseEntity(HttpStatus.OK);
    }
    
    @PutMapping("/persona/{id}")
    public ResponseEntity ActulizarPersona(@PathVariable(value="id") String cedula, @RequestBody Persona request){
        personaService.Put(request, cedula);
        return new ResponseEntity(HttpStatus.OK);
    }
    
    @DeleteMapping("/persona/{id}")
    public ResponseEntity EliminarPersona(@PathVariable(value="id") String cedula){
        return new ResponseEntity(HttpStatus.OK);
    }
}
