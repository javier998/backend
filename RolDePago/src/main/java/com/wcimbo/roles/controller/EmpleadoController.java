/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wcimbo.roles.controller;

import com.wcimbo.roles.entity.Empleado;
import com.wcimbo.roles.service.EmpleadoService;
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

public class EmpleadoController {
    
    @Autowired
    EmpleadoService empleadoService;
    
    @GetMapping("/empleados")
    public List<Empleado> ObtenerEmpleados(){
       return empleadoService.GetAll();
    }
    
    @GetMapping("/empleado/{id}")
    public Empleado ObtenerEmpleado(@PathVariable (value = "id") long id){
        return empleadoService.GetById(id);
    }
    
    @PostMapping("/empleado")
    public ResponseEntity GuardarEmpleado(@RequestBody Empleado request){
        empleadoService.Post(request);
        return new ResponseEntity(HttpStatus.OK);
    }
    
    @PutMapping("/empleado/{id}")
    public ResponseEntity ActualizarEmpleado(@PathVariable(value = "id")long id, @RequestBody Empleado request){
        empleadoService.Put(request, id);
        return new ResponseEntity(HttpStatus.OK);
    }
    
    @DeleteMapping("/empleado/{id}")
    public ResponseEntity EliminarEmpleado(@PathVariable(value = "id")long id){
        empleadoService.DeleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
