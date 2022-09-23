package com.wcimbo.roles.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name="tipo_usuario")
public class TipoUsuario implements Serializable {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="tipo_usuario_id")
    private long id;
    
    @Column(name="tipo_usuario")
    private String nombre;
}
