package com.wcimbo.roles.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
@Table(name="persona")
public class Persona implements Serializable  {
    
    @Id
    @Column(name = "persona_id")
    private String cedula;
    
    @Column(name = "nombre_persona")
    private String nombre;
    
    @Column(name="apellido_persona")
    private String apellido;
    
    @Column(name="telefono_persona")
    private String telefono;
    
    @Column(name="correo_persona")
    private String correo;
    
    @Column(name="fecha_nacimiento")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date fechaNacimeinto;

    
    
    
}
