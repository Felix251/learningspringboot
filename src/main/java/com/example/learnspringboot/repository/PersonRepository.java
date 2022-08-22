package com.example.learnspringboot.repository;

import com.example.learnspringboot.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    @Query("SELECT p FROM  Person  p where  p.firstName = ?1 and p.lastName = ?2")
    Person findByFistnameAndLastname(String Firstname, String Lastname);
    List<Person> findByDepartement_Id(Long id);

}
