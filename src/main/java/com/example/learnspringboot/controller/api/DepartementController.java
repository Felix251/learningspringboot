package com.example.learnspringboot.controller.api;

import com.example.learnspringboot.model.Departement;
import com.example.learnspringboot.service.DepartementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/departement")
public class DepartementController {
    DepartementService departementService;

    public DepartementController(DepartementService departementService) {
        this.departementService = departementService;
    }

    @GetMapping
    public ResponseEntity<List<Departement>> getAllDepartement(){
        return new ResponseEntity<>(departementService.getAllDepartement(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<List<Departement>> createDepartement(@RequestBody Departement departement){
        departementService.create(departement);
        return new ResponseEntity<>(departementService.getAllDepartement(), HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<List<Departement>> modifyDepartement(@PathVariable Long id){
        departementService.deleteDepartement(id);
        return new ResponseEntity<>(departementService.getAllDepartement(), HttpStatus.OK);
    }
}
