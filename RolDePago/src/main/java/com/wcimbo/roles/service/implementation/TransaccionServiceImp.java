/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wcimbo.roles.service.implementation;

import com.wcimbo.roles.entity.Transaccion;
import com.wcimbo.roles.repository.TransaccionRepository;
import com.wcimbo.roles.service.TransaccionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author javi_
 */
@Service
public class TransaccionServiceImp implements TransaccionService{

    @Autowired
    TransaccionRepository transaccion;
    
    /** Funcion que lista la informacion de transaccion
     * @return Transaccion[]
     * @version 1.0
     * @author Javier<javierchimbo95@gmail.com>
    */
    @Override
    public List<Transaccion> GetAll() {
        return transaccion.findAll();
    }

    /** Funcion que obtiene la informacion de una trasaccion de acuerdo a un id
     * @param id
     * @return Transaccion
     * @version 1.0
     * @author Javier<javierchimbo95@gmail.com>
    */
    @Override
    public Transaccion GetById(long id) {
        return transaccion.findById(id).get();
    }

    /** Metodo que guarda la informacion de transaccion
     * @param request
     * @version 1.0
     * @author Javier<javierchimbo95@gmail.com>
    */
    @Override
    public void Post(Transaccion request) {
        transaccion.saveAndFlush(request);
    }

    /** Metodo que actualiza la informacion de la transaccion de acuerdo al id
     * @param request
     * @param id
     * @version 1.0
     * @author Javier<javierchimbo95@gmail.com>
    */
    @Override
    public void Put(Transaccion request, long id) {
        request.setId(id);
        transaccion.saveAndFlush(request);
    }

    /** Metodo que elimina la informacion de la transaccion de acuerdo al id
     * @param id
     * @version 1.0
     * @author Javier<javierchimbo95@gmail.com>
    */
    @Override
    public void Delete(long id) {
        transaccion.deleteById(id);
    }
    
}
