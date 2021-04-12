package ru.job4j.chat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.job4j.chat.model.Person;
import ru.job4j.chat.model.Room;
import ru.job4j.chat.repository.PersonRepository;
import ru.job4j.chat.repository.RoomRepository;

import javax.persistence.Transient;
import java.util.List;
import java.util.Optional;

@Service
public class RoomService {
    private final RoomRepository roomRepository;
    private final PersonRepository personRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository, PersonRepository personRepository) {
        this.roomRepository = roomRepository;
        this.personRepository = personRepository;
    }

    public List<Room> findAll() {
        return roomRepository.findAll();
    }

    public Optional<Room> findById(int id) {
        return roomRepository.findById(id);
    }

    @Transient
    public Room create(int personFirstId, int personSecondId, Room room) {
        room.getPersons().add(personRepository.findById(personFirstId).orElse(new Person()));
        room.getPersons().add(personRepository.findById(personSecondId).orElse(new Person()));
        return roomRepository.save(room);
    }

    public void update(int personAddId, Room room) {
        if (personAddId > 0) {
            room.getPersons().add(personRepository.findById(personAddId).orElse(new Person()));
        }
        roomRepository.save(room);
    }

    public void delete(int id) {
        roomRepository.deleteById(id);
    }
}
