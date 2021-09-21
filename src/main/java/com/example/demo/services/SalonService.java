package com.example.demo.services;

import java.util.ArrayList;

import com.example.demo.models.SalonModel;
import com.example.demo.repositories.SalonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SalonService {
    @Autowired
    SalonRepository SalonRepository;
    
    public ResponseEntity<ArrayList<SalonModel>> obtenerSalones(){
        ArrayList<SalonModel> salones = (ArrayList<SalonModel>) SalonRepository.findAll();
        return new ResponseEntity<ArrayList<SalonModel>>(salones, HttpStatus.OK);
    }

    public ResponseEntity<HttpStatus> guardarSalon(SalonModel salon){
        try {
            SalonRepository.save(salon);
            return new ResponseEntity<HttpStatus>(HttpStatus.OK);   
        } catch (Exception e) {
            return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);  
        }
    }

    public ResponseEntity<HttpStatus> eliminarSalon(Long id) {
        try{
            SalonRepository.deleteById(id);
            return new ResponseEntity<HttpStatus>(HttpStatus.OK);
        }catch(Exception err){
            return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);  
        }
    }
    
}
