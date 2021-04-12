package ru.job4j.chat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.job4j.chat.model.Message;

public interface MessageRepository extends JpaRepository<Message, Integer> {
}
