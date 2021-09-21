package com.example.demo.repositories;

import com.example.demo.models.SalonModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalonRepository extends CrudRepository<SalonModel, Long> {
    
}
