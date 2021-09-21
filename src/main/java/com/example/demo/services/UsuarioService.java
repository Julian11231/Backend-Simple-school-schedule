package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.RecordNotFoundException;
import com.example.demo.models.UsuarioModel;
import com.example.demo.repositories.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;
    
    public ArrayList<UsuarioModel> obtenerUsuarios(){
        return (ArrayList<UsuarioModel>) usuarioRepository.findAll();
    }

    public UsuarioModel guardarUsuario(UsuarioModel usuario){
        return usuarioRepository.save(usuario);
    }

    public Optional<UsuarioModel> obtenerPorId(Long id){
        return usuarioRepository.findById(id);
    }

    public ResponseEntity<UsuarioModel> login(UsuarioModel usuario) {
        if(usuario.getIdentificacion() != (long)usuario.getIdentificacion()){
            throw new RecordNotFoundException("Indentifiación inválida");
        }
        UsuarioModel user = usuarioRepository.findByIdentificacion(usuario.getIdentificacion());
        if(user == null) {
            throw new RecordNotFoundException("Usuario no existe");
       }else{
           if(user.getPassword() == usuario.getPassword()){
            return new ResponseEntity<UsuarioModel>(user, HttpStatus.OK);
           }else{
            throw new RecordNotFoundException("Constraseña incorrecta");
           }
       }
    }

    /*
    public ArrayList<UsuarioModel>  obtenerPorPrioridad(Integer prioridad) {
        return usuarioRepository.findByPrioridad(prioridad);
    }
    */

    public boolean eliminarUsuario(Long id) {
        try{
            usuarioRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }
    
}