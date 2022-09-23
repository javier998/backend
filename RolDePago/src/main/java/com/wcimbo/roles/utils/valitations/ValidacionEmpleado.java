
package com.wcimbo.roles.utils.valitations;

import com.wcimbo.roles.entity.Empleado;
import com.wcimbo.roles.utils.exceptions.RequestException;
import org.springframework.http.HttpStatus;

public class ValidacionEmpleado {

    public ValidacionEmpleado() {

    }
    
    public void existe(Boolean ban){
        if(!ban){
            throw new RequestException("No existes el empleado", "p-1001", HttpStatus.BAD_REQUEST);
        }
    }

    public void validacion(Empleado empleado) {

        if (empleado.getCargo().length() == 0 || empleado.getCargo().length() == 0) {
            throw new RequestException("Campo de cargo esta vacio", "p-1", HttpStatus.BAD_REQUEST);
        }

        if (empleado.getSueldo() < 0) {
            throw new RequestException("Campo de sueldo es negativo", "p-2", HttpStatus.BAD_REQUEST);
        }

        if (empleado.getPersona() == null) {
            throw new RequestException("No hay datos de persona", "p-4", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if (empleado.getUsuario() == null) {
            throw new RequestException("No hay datos de usuario", "p-4", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
         
        for (int i = 0; i < empleado.getCargo().length(); i++) {
            char n = empleado.getCargo().charAt(i);
            if (!(n >= 'a' && n <= 'z') || !(n >= 'A' && n <= 'Z')) {
                throw new RequestException("Campo cargo solo debe contener letras", "p-3", HttpStatus.BAD_REQUEST);
            }
        }

        
        if (!(empleado.getCargo().length() > 3 && empleado.getCargo().length() < 17)) {
            throw new RequestException("Campo cargo solo debe contener letras", "p-3", HttpStatus.BAD_REQUEST);
        }
    }
}
