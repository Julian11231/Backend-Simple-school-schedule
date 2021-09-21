package com.example.demo.controllers;

import java.util.ArrayList;
//import java.util.Optional;

import com.example.demo.models.CursoModel;
import com.example.demo.models.HorarioModel;
import com.example.demo.models.SalonModel;
//import com.example.demo.repositories.HorarioRepository;
import com.example.demo.services.HorarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/horario")
public class HorarioController {
    @Autowired
    HorarioService HorarioService;

    @GetMapping()
    public ResponseEntity<ArrayList<HorarioModel>> obtenerHorarios(){
        return HorarioService.obtenerHorarios();
    }

    @GetMapping(path = "/salon/{id}")
    public ResponseEntity<ArrayList<HorarioModel>> obtenerHorariosPorSalon(@PathVariable("id") Long id){
        return HorarioService.obetnerPorSalon(id);
    }

    @PostMapping()
    public ResponseEntity<HttpStatus> guardarHorario(@RequestParam Long salon_id, @RequestParam Long curso_id, @RequestBody HorarioModel horario){
        CursoModel curso = this.HorarioService.getCurso(curso_id);
        SalonModel salon = this.HorarioService.getSalon(salon_id);
        horario.setCurso(curso);
        horario.setSalon(salon);
        return this.HorarioService.guardarHorario(horario);
    }

    @DeleteMapping( path = "/{id}")
    public ResponseEntity<?> eliminarPorId(@PathVariable("id") Long id){
        return this.HorarioService.eliminarHorario(id);
    }

}
