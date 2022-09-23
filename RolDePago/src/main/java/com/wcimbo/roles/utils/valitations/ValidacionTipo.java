package com.wcimbo.roles.utils.valitations;

import com.wcimbo.roles.entity.TipoUsuario;
import com.wcimbo.roles.utils.exceptions.RequestException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class ValidacionTipo {
    
    public ValidacionTipo(){
        
    }
    
    public void existe(Boolean ban){
        if(!ban){
            throw new RequestException("No existes el tipo", "p-1001", HttpStatus.BAD_REQUEST);
        }
    }
    
    public void ValidacionCadena(String cadena) {
        
        if(cadena.length()==0){
            throw new RequestException("Campo nombre vacio", "p-1", HttpStatus.BAD_REQUEST);
        }
        
        if(!(cadena.length()>5 && cadena.length()<17)){
            throw new RequestException("Campo nombre debe contener entre 6 a 16 caracteres", "p-2", HttpStatus.BAD_REQUEST);
        }
        
        
//        for (int i = 0; i < cadena.length(); i++) {
//            char n = cadena.charAt(i);
//            if(!(n>='a' && n<='z')||!(n>='A' && n<='Z')){
//                throw new RequestException("Campo nombre solo debe contener letras o vocales", "p-3", HttpStatus.BAD_REQUEST);
//            }
//            
//        }
        
    }
}
