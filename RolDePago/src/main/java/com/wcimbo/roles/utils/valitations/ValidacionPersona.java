package com.wcimbo.roles.utils.valitations;

import com.wcimbo.roles.entity.Persona;
import com.wcimbo.roles.utils.exceptions.RequestException;
import org.springframework.http.HttpStatus;

public class ValidacionPersona {

    public ValidacionPersona() {

    }
    
    public void existe(Boolean ban){
        if(!ban){
            throw new RequestException("No existes la persona", "p-1001", HttpStatus.BAD_REQUEST);
        }
    }

    public void validacion(Persona persona) {
        validarCedula(persona.getCedula());
        
        if (persona.getCedula().length() != 10) {
            throw new RequestException("Cedula incorrecta", "p-5", HttpStatus.BAD_REQUEST);
        }

        try {
            Integer.parseInt(persona.getCedula());
        } catch (NumberFormatException e) {
            throw new RequestException("Cedula incorrecta", "p-5", HttpStatus.BAD_REQUEST);
        }

        if (!validarCedula(persona.getCedula())) {
            throw new RequestException("Cedula incorrecta", "p-5", HttpStatus.BAD_REQUEST);
        }

        if (persona.getNombre().length() == 0 || persona.getNombre() == null) {
            throw new RequestException("El campo de nombre esta vacio", "p-1", HttpStatus.BAD_REQUEST);
        }

        for (int i = 0; i < persona.getNombre().length(); i++) {
            char n = persona.getNombre().charAt(i);
            if (!(n >= 'a' && n <= 'z') || !(n >= 'A' && n <= 'Z')) {
                throw new RequestException("Campo nombre solo debe contener letras o vocales", "p-3", HttpStatus.BAD_REQUEST);
            }
        }

        if (persona.getApellido().length() == 0 || persona.getApellido() == null) {
            throw new RequestException("El campo de nombre esta vacio", "p-1", HttpStatus.BAD_REQUEST);
        }

        for (int i = 0; i < persona.getApellido().length(); i++) {
            char n = persona.getApellido().charAt(i);
            if (!(n >= 'a' && n <= 'z') || !(n >= 'A' && n <= 'Z')) {
                throw new RequestException("Campo apellido solo debe contener letras o vocales", "p-3", HttpStatus.BAD_REQUEST);
            }
        }
        
        if(persona.getCorreo().length() == 0 || persona.getCorreo() == null){
            throw new RequestException("El campo de correo esta vacio", "p-1", HttpStatus.BAD_REQUEST);
        }
        
        if(persona.getTelefono().length() == 0 || persona.getTelefono()== null){
            throw new RequestException("El campo de telefono esta vacio", "p-1", HttpStatus.BAD_REQUEST);
        }
        
        try {
            Integer.parseInt(persona.getTelefono());
        } catch (NumberFormatException e) {
            throw new RequestException("Telefono incorrecta", "p-5", HttpStatus.BAD_REQUEST);
        }

    }

    public boolean validarCedula(String cedula) {
        return true;
    }
}
