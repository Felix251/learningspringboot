package com.example.learnspringboot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Departement")
public class Departement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "departement", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Person> persons = new ArrayList<>();

    public Departement() {

    }

    public Departement(String name) {
        this.name = name;
    }

//    public Departement(String name, List<Person> persons) {
//        this.name = name;
//        this.persons = persons;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public List<Person> getPersons() {
//        return persons;
//    }
//
//    public void setPersons(List<Person> persons) {
//        this.persons = persons;
//    }

    @Override
    public String toString() {
        return "Departement{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }


}
