/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wcimbo.roles.service;

import com.wcimbo.roles.entity.TipoUsuario;

import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author javi_
 */
@Service
public interface TipoUsuarioService {
    List<TipoUsuario> GetAll();
    
    public TipoUsuario GetById(long id);
    
    public void Post(TipoUsuario request);
    
    public void Put(TipoUsuario request, long id);
    
    public void DeleteById(long id);
}
