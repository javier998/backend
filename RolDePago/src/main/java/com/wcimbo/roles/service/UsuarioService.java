/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wcimbo.roles.service;

import com.wcimbo.roles.entity.Usuario;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author javi_
 */
@Service
public interface UsuarioService {
    
    List<Usuario> GetAll();
    
    public Usuario GetByID(String username);
    
    public void Post(Usuario request);
    
    public void Put(Usuario request, String username);
    
    public void DeleteById(String username);
    
    public Usuario Token(Usuario request);
}
