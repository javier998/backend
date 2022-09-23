package com.wcimbo.roles.service.implementation;

import com.wcimbo.roles.entity.Usuario;
import com.wcimbo.roles.repository.UsuarioRepository;
import com.wcimbo.roles.service.UsuarioService;
import com.wcimbo.roles.utils.valitations.ValidacionUsuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImp implements UsuarioService{
   
    ValidacionUsuario validacion = new ValidacionUsuario();
    
    @Autowired
    UsuarioRepository usuarioRepository;
    
    /** Funcion que lista la informacion de usuario
     * @return Usuario[]
     * @version 1.0
     * @author Javier<javierchimbo95@gmail.com>
    */
    @Override
    public List<Usuario> GetAll() {
        return usuarioRepository.findAll();
    }

    /** Funcion que obtiene la informacion de un usuario de acuerdo a un id
     * @param username
     * @return Usuario
     * @version 1.0
     * @author Javier<javierchimbo95@gmail.com>
    */
    @Override
    public Usuario GetByID(String username) {
        validacion.existe(usuarioRepository.existsById(username));
        return usuarioRepository.findById(username).get();
    }

    /** Metodo que guarda la informacion de usuario
     * @param request
     * @version 1.0
     * @author Javier<javierchimbo95@gmail.com>
    */
    @Override
    public void Post(Usuario request) {
        validacion.validacionCampos(request);
        usuarioRepository.saveAndFlush(request);
    }

    /** Metodo que actualiza la informacion del usuario de acuerdo al username
     * @param request
     * @param username
     * @version 1.0
     * @author Javier<javierchimbo95@gmail.com>
    */
    @Override
    public void Put(Usuario request, String username) {
        request.setNombre(username);
        usuarioRepository.saveAndFlush(request);
    }

    /** Metodo que elimina la informacion de un usuario de acuerdo al username
     * @param username
     * @version 1.0
     * @author Javier<javierchimbo95@gmail.com>
    */
    @Override
    public void DeleteById(String username) {
        usuarioRepository.deleteById(username);
    }

     /** Metodo que verifica la informacion de un usuario de acuerdo al username
     * @param request
     * @return Usuario
     * @version 1.0
     * @author Javier<javierchimbo95@gmail.com>
    */
    @Override
    public Usuario Token(Usuario request) {
         validacion.existe(usuarioRepository.existsById(request.getNombre()));
        validacion.VerificarExistencia(request.getNombre(), request.getPassword(),usuarioRepository.findById(request.getNombre()).get() );
        return usuarioRepository.findById(request.getNombre()).get();
    }

   
    
}
