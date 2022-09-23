/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wcimbo.roles.service.implementation;

import com.wcimbo.roles.entity.TipoUsuario;
import com.wcimbo.roles.repository.TipoUsuarioRepository;
import com.wcimbo.roles.service.TipoUsuarioService;
import com.wcimbo.roles.utils.valitations.ValidacionTipo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author javi_
 */
@Service
public class TipoUsuarioImp implements TipoUsuarioService{

    @Autowired
    TipoUsuarioRepository tipoUsuarioRepository;
    
    ValidacionTipo validacion = new ValidacionTipo();
    
    /** Funcion que lista la informacion de tipo de usuario
     * @return TipoUsario[]
     * @version 1.0
     * @author Javier<javierchimbo95@gmail.com>
    */
    @Override
    public List<TipoUsuario> GetAll() {
        return tipoUsuarioRepository.findAll();
    }

    /** Funcion que obtiene la informacion de un tipo de usuario de acuerdo a un id
     * @param id
     * @return TipoUsuario
     * @version 1.0
     * @author Javier<javierchimbo95@gmail.com>
    */
    @Override
    public TipoUsuario GetById(long id) {
        validacion.existe(tipoUsuarioRepository.existsById(id));
        return tipoUsuarioRepository.findById(id).get();
    }

    /** Metodo que guarda la informacion de tipo de usuario
     * @param request
     * @version 1.0
     * @author Javier<javierchimbo95@gmail.com>
    */
    @Override
    public void Post(TipoUsuario request){
            validacion.ValidacionCadena(request.getNombre());
            tipoUsuarioRepository.saveAndFlush(request);
    }

    /** Metodo que actualiza la informacion de tipo de usuario de acuerdo al id
     * @param request
     * @param id
     * @version 1.0
     * @author Javier<javierchimbo95@gmail.com>
    */
    @Override
    public void Put(TipoUsuario request, long id) {
        System.out.println("llegaaaaaa "+ id);
        validacion.ValidacionCadena(request.getNombre());
        request.setId(id);
        
        tipoUsuarioRepository.saveAndFlush(request);
    }

    /** Metodo que elimina la informacion de un tipo de usuario de acuerdo al id
     * @param id
     * @version 1.0
     * @author Javier<javierchimbo95@gmail.com>
    */
    @Override
    public void DeleteById(long id){
        validacion.existe(tipoUsuarioRepository.existsById(id));
        tipoUsuarioRepository.deleteById(id);
    }
 
}
