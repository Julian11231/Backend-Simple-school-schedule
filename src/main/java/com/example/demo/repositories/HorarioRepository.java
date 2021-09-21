package com.example.demo.repositories;

import java.util.ArrayList;

import com.example.demo.models.HorarioModel;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HorarioRepository extends CrudRepository<HorarioModel, Long> {
    @Query(value = "SELECT * FROM horarios INNER JOIN cursos on horarios.curso_id = cursos.id INNER JOIN salones on horarios.salon_id = salones.id", nativeQuery = true)
    public abstract ArrayList<HorarioModel> findAllHorarios();

    @Query(value = "SELECT * FROM horarios  INNER JOIN salones ON salones.id = horarios.salon_id WHERE salones.id = ?1 ORDER BY fecha", nativeQuery = true)
    public abstract ArrayList<HorarioModel> findPorSalon(Long id);
}
