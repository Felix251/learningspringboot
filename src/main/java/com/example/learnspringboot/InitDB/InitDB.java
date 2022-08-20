package com.example.learnspringboot.InitDB;

import com.example.learnspringboot.model.Departement;
import com.example.learnspringboot.model.Person;
import com.example.learnspringboot.service.DepartementService;
import com.example.learnspringboot.service.PersonService;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class InitDB implements ApplicationListener<ApplicationReadyEvent> {
    PersonService personService;
    DepartementService departementService;

    public InitDB(PersonService personService, DepartementService departementService) {
        this.personService = personService;
        this.departementService = departementService;
    }


    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        System.out.println("Application ready");

        //create departements
        Departement departement1 = new Departement("Informatique");
        Departement departement2 = new Departement("Gestion");
        //Insert Departements in the database
        departementService.createAll(List.of(departement1, departement2));
        //Create person objet
        Person person1 = new Person("Felix", "Ndao", 20, departement1);
        Person person2 = new Person("Jean", "Camara", 17, departement2);
        Person person3 = new Person("Marie", "Dione", 20, departement2);
        //Insert Persons in the database
        personService.create(person1);
        personService.createAll(List.of(person2, person3));
        //Afficher tous les personnes et les departements dans la console
        System.out.println("Personnes : ");
        System.out.println(personService.getAllPerson());
        System.out.println("specific person : ");
        System.out.println(personService.getPersonByFirstnameAndLastname("Felix", "Ndao"));
        System.out.println("Departements : ");
        System.out.println(departementService.getAllDepartement());
    }
}
