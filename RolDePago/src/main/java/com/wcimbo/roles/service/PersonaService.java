/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wcimbo.roles.service;

import com.wcimbo.roles.entity.Persona;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author javi_
 */
@Service
public interface PersonaService {
    List<Persona> GetAll();
    
    public Persona GetById(String cedula);
    
    public void Post(Persona request);
    
    public void Put(Persona request, String cedula);
    
    public void DeleteById(String cedula);
}
