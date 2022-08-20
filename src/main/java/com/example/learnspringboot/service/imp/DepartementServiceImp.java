package com.example.learnspringboot.service.imp;

import com.example.learnspringboot.model.Departement;
import com.example.learnspringboot.repository.DepartementRepository;
import com.example.learnspringboot.service.DepartementService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartementServiceImp implements DepartementService {
    private final DepartementRepository departementRepository;

    public DepartementServiceImp(DepartementRepository departementRepository) {
        this.departementRepository = departementRepository;
    }

    @Override
    public Departement create(Departement departement) {
        return departementRepository.save(departement);
    }

    @Override
    public List<Departement> createAll(List<Departement> departements) {
        return departementRepository.saveAll(departements);
    }

    @Override
    public Optional<Departement> getDepartement(Long id) {
        return departementRepository.findById(id);
    }

    @Override
    public List<Departement> getAllDepartement() {
        return departementRepository.findAll();
    }

    @Override
    public void deleteDepartement(Long id) {
        departementRepository.deleteById(id);
    }
}
