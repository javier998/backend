/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wcimbo.roles.service;

import com.wcimbo.roles.entity.Empleado;

import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author javi_
 */

@Service
public interface EmpleadoService {
    
    List<Empleado> GetAll();
    
    public Empleado GetById(long id);
    
    public void Post(Empleado request);
    
    public void Put(Empleado request, long id);
    
    public void DeleteById(long id);
}
