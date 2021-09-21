package com.example.demo.controllers;

import java.util.ArrayList;

import com.example.demo.models.CursoModel;
import com.example.demo.services.CursoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/curso")
public class CursoController {
    @Autowired
    CursoService CursoService;

    @GetMapping()
    public ResponseEntity<ArrayList<CursoModel>> obtenerCursos(){
        return CursoService.obtenerCursos();
    }

    @PostMapping()
    public ResponseEntity<HttpStatus> guardarCurso(@RequestBody CursoModel usuario){
        return this.CursoService.guardarCurso(usuario);
    }

    @DeleteMapping( path = "/{id}")
    public ResponseEntity<HttpStatus> eliminarPorId(@PathVariable("id") Long id){
        return this.CursoService.eliminarCurso(id);
    }

}
