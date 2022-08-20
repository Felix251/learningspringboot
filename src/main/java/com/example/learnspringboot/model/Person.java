package com.example.learnspringboot.model;

import javax.persistence.*;

@Entity
@Table(name = "Person_table")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "prenom")
    private String firstName;
    @Column(name = "nom")
    private String lastName;
    @Column(name = "age")
    private int age;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "departement_id", nullable = false)
    private Departement departement;

    public Person() {

    }

    public Person(String firstName, String lastName, int age, Departement departement) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.departement = departement;
    }



    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", departement=" + departement +
                '}';
    }
}
