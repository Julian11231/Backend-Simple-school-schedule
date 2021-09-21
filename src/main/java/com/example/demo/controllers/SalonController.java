package com.example.demo.controllers;

import java.util.ArrayList;

import com.example.demo.models.SalonModel;
import com.example.demo.services.SalonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/salon")
public class SalonController {
    @Autowired
    SalonService SalonService;

    @GetMapping()
    public ResponseEntity<ArrayList<SalonModel>> obtenerSalones(){
        return SalonService.obtenerSalones();
    }

    @PostMapping()
    public ResponseEntity<HttpStatus> guardarSalon(@RequestBody SalonModel usuario){
        return this.SalonService.guardarSalon(usuario);
    }

    @DeleteMapping( path = "/{id}")
    public ResponseEntity<HttpStatus> eliminarPorId(@PathVariable("id") Long id){
        return this.SalonService.eliminarSalon(id);
    }

}
