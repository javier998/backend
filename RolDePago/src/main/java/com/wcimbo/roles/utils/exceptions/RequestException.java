    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wcimbo.roles.utils.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 *
 * @author javi_
 */
@Data
public class RequestException extends RuntimeException{

    private String code;
    private HttpStatus status;
    
    public RequestException(String mensaje, String code, HttpStatus status) {
        super(mensaje);
        this.code = code;
        this.status = status;
    }
    
}
