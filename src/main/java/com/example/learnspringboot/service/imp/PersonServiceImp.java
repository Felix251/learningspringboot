package com.example.learnspringboot.service.imp;

import com.example.learnspringboot.model.Person;
import com.example.learnspringboot.repository.PersonRepository;
import com.example.learnspringboot.service.PersonService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImp implements PersonService {
    private final PersonRepository personRepository;

    public PersonServiceImp(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person create(Person person) {
        return personRepository.save(person);
    }

    @Override
    public List<Person> createAll(List<Person> persons) {
        return personRepository.saveAll(persons);
    }

    @Override
    public Optional<Person> getPerson(Long id) {
        return personRepository.findById(id);
    }

    @Override
    public Person getPersonByFirstnameAndLastname(String firstname, String lastname) {
        return personRepository.findByFistnameAndLastname(firstname, lastname);
    }

    @Override
    public List<Person> getAllPerson() {
        return personRepository.findAll();
    }

    @Override
    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }

    @Override
    public void test() {

    }

    @Override
    public Person modifyPerson(Long id, Person person) {
        Person existingPerson = personRepository.getOne(id);
        existingPerson.setFirstName(person.getFirstName());
        existingPerson.setLastName(person.getLastName());
        existingPerson.setAge(person.getAge());
        personRepository.save(existingPerson);
        return personRepository.save(existingPerson);
    }

    @Override
    public List<Person> getPersonBYDepartementId(Long id) {
        return personRepository.findByDepartement_Id(id);
    }

}
