package com.wcimbo.roles.service.implementation;

import com.wcimbo.roles.entity.Empleado;
import com.wcimbo.roles.entity.Persona;
import com.wcimbo.roles.entity.TipoUsuario;
import com.wcimbo.roles.entity.Usuario;
import com.wcimbo.roles.repository.EmpleadoRepository;
import com.wcimbo.roles.repository.PersonaRepository;
import com.wcimbo.roles.repository.TipoUsuarioRepository;
import com.wcimbo.roles.repository.UsuarioRepository;
import com.wcimbo.roles.service.EmpleadoService;
import com.wcimbo.roles.utils.valitations.ValidacionEmpleado;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoServiceImp implements EmpleadoService {

    ValidacionEmpleado validacio = new ValidacionEmpleado();

    @Autowired
    EmpleadoRepository empleadoRepository;
    
    @Autowired
    TipoUsuarioRepository tipoRepository;
    
    @Autowired
    PersonaRepository personaRepository;
    
    @Autowired
    UsuarioRepository usuarioRepository;

    /** Funcion que lista la informacion de empleado
     * @return Empleado[] 
     * @version: 1.0
     * @author: Javier<javierchimbo95@gmail.com>
    */
    @Override
    public List<Empleado> GetAll() {
        return empleadoRepository.findAll();
    }

    /** Funcion que obtiene informacion de un usuario de acuerdo al id
     * @param id
     * @return Empleado     
     * @version 1.0
     * @author Javier<javierchimbo95@gmail.com>
    */
    @Override
    public Empleado GetById(long id) {
        validacio.existe(empleadoRepository.existsById(id));
        return empleadoRepository.findById(id).get();
    }

    /** Metodo que guarda informacion de un empleado
     *@param request
     *@version 1.0
     *@author Javier<javierchimbo95@gmail.com>
    */
    @Override
    public void Post(Empleado request) {
        System.out.println(request.toString());
        Persona persona = new Persona();
        Usuario usuario = new Usuario();
        TipoUsuario tipoUsuario = new TipoUsuario();
        
        persona = request.getPersona();
        usuario = request.getUsuario();
        tipoUsuario=tipoRepository.findById(request.getUsuario().getTipoUsario().getId()).get();
        usuario.setTipoUsario(tipoUsuario);

        personaRepository.saveAndFlush(persona);
        usuarioRepository.saveAndFlush(usuario);
        
        //validacio.validacion(request);
        empleadoRepository.saveAndFlush(request);
    }
    
    /** Metodo que recibe informacion de un empleado para actulizar de acuerdo al id
     * @param request
     * @param id
     * @version 1.0
     * @author Javier<javierchimbo95@gmail.com>
    */
    @Override
    public void Put(Empleado request, long id) {

        validacio.validacion(request);
        request.setId(id);
        empleadoRepository.saveAndFlush(request);
    }

    /** Metodo que recibe un id de un empleado para ser eliminado
     * @param id
     * @version 1.0
     * @author Javier<javierchimbo95@gmail.com>
    */
    @Override
    public void DeleteById(long id) {
        validacio.existe(empleadoRepository.existsById(id));
        empleadoRepository.deleteById(id);
    }

}
