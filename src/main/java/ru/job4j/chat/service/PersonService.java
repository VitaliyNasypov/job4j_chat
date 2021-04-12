package ru.job4j.chat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.job4j.chat.model.Person;
import ru.job4j.chat.model.Role;
import ru.job4j.chat.repository.PersonRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    private final PersonRepository personService;

    @Autowired
    public PersonService(PersonRepository personService) {
        this.personService = personService;
    }

    public List<Person> findAll() {
        return personService.findAll();
    }

    public Optional<Person> findById(int id) {
        return personService.findById(id);
    }

    public Person create(int roleId, Person person) {
        Role role = new Role();
        role.setId(roleId);
        role.addPerson(person);
        return personService.save(person);
    }

    public void update(int roleId, Person person) {
        Role role = new Role();
        role.setId(roleId);
        role.addPerson(person);
        personService.save(person);
    }

    public void delete(int id) {
        personService.deleteById(id);
    }
}
