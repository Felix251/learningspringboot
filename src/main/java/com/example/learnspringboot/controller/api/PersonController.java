package com.example.learnspringboot.controller.api;

import com.example.learnspringboot.model.Person;
import com.example.learnspringboot.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/person")
public class PersonController {
     private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public List<Person> getAllPersons(){
        return personService.getAllPerson();
    }
    @GetMapping("/fnln")
    public ResponseEntity<Person> findByFirstnameAndLastname(@RequestParam("firstname") String firstname, @RequestParam("lastname") String lastname){
        return new ResponseEntity<>(personService.getPersonByFirstnameAndLastname(firstname, lastname), HttpStatus.OK);
    }
    @GetMapping("departement/{id}")
    public ResponseEntity<List<Person>> findByDepartementId(@PathVariable Long id){
        return new ResponseEntity<>(personService.getPersonBYDepartementId(id), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<List<Person>> createPerson(@RequestBody Person person){
        personService.create(person);
        return new ResponseEntity<>(personService.getAllPerson(), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public  List<Person> modifyPerson(@PathVariable Long id, @RequestBody  Person person){
        personService.modifyPerson(id, person);
        return personService.getAllPerson();
    }
    @DeleteMapping("/{id}")
    public List<Person> deletePerson(@PathVariable Long id){
        personService.deletePerson(id);
        return personService.getAllPerson();
    }
}
