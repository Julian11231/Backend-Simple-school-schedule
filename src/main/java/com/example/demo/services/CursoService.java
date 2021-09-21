package com.example.demo.services;

import java.util.ArrayList;

import com.example.demo.models.CursoModel;
import com.example.demo.repositories.CursoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CursoService {
    @Autowired
    CursoRepository CursoRepository;
    
    public ResponseEntity<ArrayList<CursoModel>> obtenerCursos(){
        ArrayList<CursoModel> cursos = (ArrayList<CursoModel>) CursoRepository.findAll();
        return new ResponseEntity<ArrayList<CursoModel>>(cursos, HttpStatus.OK);
    }

    public ResponseEntity<ArrayList<CursoModel>> obtenerCursosActivos(){
        ArrayList<CursoModel> cursos = (ArrayList<CursoModel>) CursoRepository.findByEstado(true);
        return new ResponseEntity<ArrayList<CursoModel>>(cursos, HttpStatus.OK);
    }

    public ResponseEntity<HttpStatus> guardarCurso(CursoModel curso){
        try {
            CursoRepository.save(curso);
            return new ResponseEntity<HttpStatus>(HttpStatus.OK);   
        } catch (Exception e) {
            return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);  
        }
    }

    public ResponseEntity<HttpStatus> eliminarCurso(Long id) {
        try{
            CursoRepository.deleteById(id);
            return new ResponseEntity<HttpStatus>(HttpStatus.OK);
        }catch(Exception err){
            return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);  
        }
    }
    
}