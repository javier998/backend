/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wcimbo.roles.repository;

import com.wcimbo.roles.entity.RolPago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author javi_
 */
@Repository
public interface RolPagoRepository extends JpaRepository<RolPago, Long>{
    
}
