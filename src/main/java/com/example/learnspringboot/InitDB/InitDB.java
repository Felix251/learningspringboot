package com.example.learnspringboot.InitDB;

import com.example.learnspringboot.model.Person;
import com.example.learnspringboot.service.PersonService;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InitDB implements ApplicationListener<ApplicationReadyEvent> {
    PersonService personService;

    public InitDB(PersonService personService) {
        this.personService = personService;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        System.out.println("Application ready");

        //Create person objet
        Person person1 = new Person("Felix", "Ndao", 20);
        Person person2 = new Person("Jean", "Camara", 17);
        Person person3 = new Person("Marie", "Dione", 20);
        //Insert Persons in the database
        personService.create(person1);
        personService.createAll(List.of(person2, person3));
        //Afficher tous les users dans la console
        System.out.println("Personnes : ");
        System.out.println(personService.getAllPerson());
        System.out.println("specific person : ");
        System.out.println(personService.getPersonByFirstnameAndLastname("Felix", "Ndao"));
    }
}
