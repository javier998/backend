/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wcimbo.roles.service.implementation;

import com.wcimbo.roles.entity.TipoConcepto;
import com.wcimbo.roles.repository.TipoConceptoRepository;
import com.wcimbo.roles.service.TipoConceptoService;
import com.wcimbo.roles.utils.valitations.ValidacionTipo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author javi_
 */
@Service
public class TipoConceptoImp implements TipoConceptoService{
    
    ValidacionTipo validacion = new ValidacionTipo();
    
    @Autowired
    TipoConceptoRepository tipoConcepto;
    
    /** Funcion que lista la informacion de tipo de concepto
     * @return TipoConcepto[]
     * @version 1.0
     * @author Javier<javierchimbo95@gmail.com>
    */
    @Override
    public List<TipoConcepto> GetAll() {
        return  tipoConcepto.findAll();
    }

    /** Funcion que obtiene la informacion de un tipo de concepto de acuerdo a un id
     * @param id
     * @return TipoConcepto
     * @version 1.0
     * @author Javier<javierchimbo95@gmail.com>
    */
    @Override
    public TipoConcepto GetById(long id) {
        validacion.existe(tipoConcepto.existsById(id));
        return tipoConcepto.findById(id).get();
    }

    /** Metodo que guarda la informacion de tipo de concepto
     * @param request
     * @version 1.0
     * @author Javier<javierchimbo95@gmail.com>
    */
    @Override
    public void Post(TipoConcepto request) {
        validacion.ValidacionCadena(request.getNombre());
        tipoConcepto.saveAndFlush(request);
    }

    /** Metodo que actualiza la informacion de tipo de concepto de acuerdo al id
     * @param request
     * @param id
     * @version 1.0
     * @author Javier<javierchimbo95@gmail.com>
    */
    @Override
    public void Put(TipoConcepto request, long id) {
        validacion.ValidacionCadena(request.getNombre());
        request.setId(id);
        tipoConcepto.saveAndFlush(request);
    }

    /** Metodo que elimina la informacion de tipo de concepto de acuerdo al id
     * @param id
     * @version 1.0
     * @author Javier<javierchimbo95@gmail.com>
    */
    @Override
    public void Delete(long id) {
        validacion.existe(tipoConcepto.existsById(id));
        tipoConcepto.deleteById(id);
    }
    
}
