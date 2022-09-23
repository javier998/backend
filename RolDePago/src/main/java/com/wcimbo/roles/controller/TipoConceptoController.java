/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wcimbo.roles.controller;

import com.wcimbo.roles.entity.TipoConcepto;
import com.wcimbo.roles.service.TipoConceptoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author javi_
 */
@RestController
public class TipoConceptoController {

    @Autowired
    TipoConceptoService tipoConceptoService;

    @GetMapping("/tipos-conceptos")
    public List<TipoConcepto> ObtenerTiposConceptos() {
        return tipoConceptoService.GetAll();
    }

    @GetMapping("/tipo-concepto/{id}")
    public TipoConcepto ObtenerTipoPorId(@PathVariable(name = "id") long id) {
        return tipoConceptoService.GetById(id);
    }

    @PostMapping("/tipo-concepto")
    public ResponseEntity GuardarTipoConcepto(@RequestBody TipoConcepto request) {
        tipoConceptoService.Post(request);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("tipo-concepto/{id}")
    public ResponseEntity ActualizarTipoConcepto(@PathVariable(name = "id") long id, @RequestBody TipoConcepto request) {
        tipoConceptoService.Put(request, id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("tipo-concepto/{id}")
    public ResponseEntity EliminarTipoConcepto(@PathVariable(name = "id") long id) {
        tipoConceptoService.Delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
