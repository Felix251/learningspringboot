package com.example.learnspringboot.service;

import com.example.learnspringboot.model.Departement;
import com.example.learnspringboot.model.Person;

import java.util.List;
import java.util.Optional;

public interface DepartementService {
    Departement create(Departement departement);
    List<Departement> createAll(List<Departement> departements);
    Optional<Departement> getDepartement(Long id);
    List<Departement> getAllDepartement();
    void deleteDepartement(Long id);
}
