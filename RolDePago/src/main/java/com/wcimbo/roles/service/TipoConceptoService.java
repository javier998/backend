/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wcimbo.roles.service;

import com.wcimbo.roles.entity.TipoConcepto;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author javi_
 */
@Service
public interface TipoConceptoService {
    List<TipoConcepto> GetAll();
    
    TipoConcepto GetById(long id);
    
    public void Post(TipoConcepto request);
    
    public void Put(TipoConcepto requests, long id);
    
    public void Delete(long id);
}
