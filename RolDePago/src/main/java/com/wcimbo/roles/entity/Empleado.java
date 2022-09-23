
package com.wcimbo.roles.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table

public class Empleado implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "empleado_id")
    private long id;
    
    @Column(name="cargo_empleado")
    private String cargo;
    
    @Column(name="sueldo_empleado")
    private double sueldo;
    
    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "persona_id")
    private Persona persona;
    
    
    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name= "usuario_id")
    private Usuario usuario;
}
