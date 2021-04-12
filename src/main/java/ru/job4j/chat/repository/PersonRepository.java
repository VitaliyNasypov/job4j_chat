package ru.job4j.chat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.job4j.chat.model.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {
}
