package com.wcimbo.roles.service.implementation;

import com.wcimbo.roles.entity.Persona;
import com.wcimbo.roles.repository.PersonaRepository;
import com.wcimbo.roles.service.PersonaService;
import com.wcimbo.roles.utils.valitations.ValidacionPersona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaServiceImp implements PersonaService{

    ValidacionPersona validacion = new ValidacionPersona();
    
    @Autowired
    PersonaRepository personaRepository;
    
    /** Funcion que lista la informacio de personas
     * @return Persona[]
     * @version 1.0
     * @author Javier<javierchimbo95@gmail.com>
    */
    @Override
    public List<Persona> GetAll() {
        return personaRepository.findAll();
    }

    /** Funcion devuelve la informacion de una persona de acuerdo a la cedula
     * @param cedula
     * @return Persona
     * @version 1.0
     * @author Javier<javierchimbo95@gmail.com>
    */
    @Override
    public Persona GetById(String cedula) {
        validacion.existe(personaRepository.existsById(cedula));
        return personaRepository.findById(cedula).get();
    }

    /** Metodo que guarda la informacion de una persona
     * @param request
     * @version 1.0
     * @author Javier<javierchimbo95@gmail.com>
    */
    @Override
    public void Post(Persona request) {
        
        validacion.validacion(request);
        personaRepository.saveAndFlush(request);
    }

    /** Metodo que actuliza la informacion de una persona de acuerdo a la cedula
     * @param request
     * @param cedula
     * @version 1.0
     * @author Javier<javierchimbo95@gmail.com>
    */
    @Override
    public void Put(Persona request, String cedula) {
        validacion.validacion(request);
        request.setCedula(cedula);
        personaRepository.saveAndFlush(request);
    }

    /** Metodo que elimina la informacion de una persona de acuerdo a la cedula
     * @param cedula
     * @version 1.0
     * @author Javier<javierchimbo95@gmail.com>
    */
    @Override
    public void DeleteById(String cedula) {
        validacion.existe(personaRepository.existsById(cedula));
        personaRepository.deleteById(cedula);
    }
    
}
