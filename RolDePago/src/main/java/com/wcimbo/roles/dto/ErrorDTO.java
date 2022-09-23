/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wcimbo.roles.dto;

import lombok.Builder;
import lombok.Data;

/**
 *
 * @author javi_
 */
@Data
@Builder
public class ErrorDTO {
    
    private String code;
    
    private String mensage;
    
}
