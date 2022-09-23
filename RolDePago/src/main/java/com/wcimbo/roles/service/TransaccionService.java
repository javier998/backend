/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wcimbo.roles.service;

import com.wcimbo.roles.entity.Transaccion;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author javi_
 */
@Service
public interface TransaccionService {
    List<Transaccion> GetAll();
    
    Transaccion GetById(long id);
    
    public void Post(Transaccion request);
    
    public void Put(Transaccion requests, long id);
    
    public void Delete(long id);
}
