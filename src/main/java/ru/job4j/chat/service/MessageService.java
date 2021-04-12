package ru.job4j.chat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.job4j.chat.model.Message;
import ru.job4j.chat.model.Person;
import ru.job4j.chat.model.Room;
import ru.job4j.chat.repository.MessageRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class MessageService {
    private final MessageRepository messageRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public List<Message> findAll() {
        return messageRepository.findAll();
    }

    public Optional<Message> findById(int id) {
        return messageRepository.findById(id);
    }

    public Message create(int personId, int roomId, Message message) {
        Person person = new Person();
        person.setId(personId);
        person.addMessage(message);
        Room room = new Room();
        room.setId(roomId);
        room.addMessage(message);
        message.setCreated(LocalDateTime.now());
        return messageRepository.save(message);
    }

    public void update(Message message) {
        messageRepository.save(message);
    }

    public void delete(int id) {
        messageRepository.deleteById(id);
    }
}
