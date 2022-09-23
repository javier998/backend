package com.wcimbo.roles.utils.valitations;

import com.wcimbo.roles.entity.Usuario;
import com.wcimbo.roles.service.UsuarioService;
import com.wcimbo.roles.utils.exceptions.RequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


@Service
public class ValidacionUsuario {
   
    @Autowired
    UsuarioService user;
    
    
    public ValidacionUsuario(){
        
    }
    
    public void validacionCampos(Usuario usuario){
        
        if(usuario.getNombre().length()==0 || usuario.getNombre()== null){
            throw new RequestException("El campo de nombre de usuario esta vacio", "p-1", HttpStatus.BAD_REQUEST);
        }
        
        if(usuario.getNombre().length()<8 || usuario.getNombre().length()>16){
            throw new RequestException("El nombre de usuario debe de estar entre 8 a 16 caracteres", "p-2", HttpStatus.BAD_REQUEST);
        }
        
        if(usuario.getPassword().length()==0 || usuario.getPassword() == null){
            throw new RequestException("El campo de password esta vacio", "p-1", HttpStatus.BAD_REQUEST);
        }
        
        if(usuario.getPassword().length()<8 || usuario.getPassword()  .length()>16){
            throw new RequestException("El nombre de usuario debe de estar entre 8 a 16 caracteres", "p-2", HttpStatus.BAD_REQUEST);
        }
        
    }
    
    
    public void existe(Boolean ban){
        if(!ban){
            throw new RequestException("No existes el usuario", "p-1001", HttpStatus.BAD_REQUEST);
        }
    }
    
    public void VerificarExistencia(String username, String password, Usuario usuario ){
                
       if(!(usuario.getNombre().equals(username) && usuario.getPassword().equals(password))){
            System.out.println("llego a validacion");
           throw new RequestException("Error de credenciales", "p-1000", HttpStatus.BAD_REQUEST);
       }
    }
}
