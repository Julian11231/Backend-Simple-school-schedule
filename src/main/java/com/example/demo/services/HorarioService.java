package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.CursoModel;
//import com.example.demo.RecordNotFoundException;
//import com.example.demo.models.CursoModel;
import com.example.demo.models.HorarioModel;
import com.example.demo.models.SalonModel;
//import com.example.demo.models.SalonModel;
import com.example.demo.repositories.CursoRepository;
import com.example.demo.repositories.HorarioRepository;
import com.example.demo.repositories.SalonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class HorarioService {
    @Autowired
    HorarioRepository HorarioRepository;

    @Autowired
    CursoRepository CursoRepository;

    @Autowired
    SalonRepository SalonRepository;
    
    public ResponseEntity<ArrayList<HorarioModel>> obtenerHorarios(){
        ArrayList<HorarioModel> horario = (ArrayList<HorarioModel>) HorarioRepository.findAllHorarios();
        return new ResponseEntity<ArrayList<HorarioModel>>(horario, HttpStatus.OK);
    }

    public ResponseEntity<ArrayList<HorarioModel>> obetnerPorSalon(Long salon_id){
        ArrayList<HorarioModel> horario = (ArrayList<HorarioModel>) HorarioRepository.findPorSalon(salon_id);
        return new ResponseEntity<ArrayList<HorarioModel>>(horario, HttpStatus.OK);
    }

    public CursoModel getCurso(Long curso_id){
        Optional<CursoModel> curso = CursoRepository.findById(curso_id);
        if(curso.isPresent()) {
            return curso.get();
        }else{
            return null;
        }
    }

    public SalonModel getSalon(Long salon_id){
        Optional<SalonModel> salon = SalonRepository.findById(salon_id);
        if(salon.isPresent()) {
            return salon.get();
        }else{
            return null;
        }
    }

    public ResponseEntity<HttpStatus> guardarHorario(HorarioModel horario){
        try {
            HorarioRepository.save(horario);
            return new ResponseEntity<HttpStatus>(HttpStatus.OK);   
        } catch (Exception e) {
            return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);  
        }
    }

    public ResponseEntity<?> eliminarHorario(Long id) {
        try{
            HorarioRepository.deleteById(id);
            return new ResponseEntity<HttpStatus>(HttpStatus.OK);
        }catch(Exception err){
            return new ResponseEntity<Exception>(err, HttpStatus.INTERNAL_SERVER_ERROR); 
        }
    }
    
}
