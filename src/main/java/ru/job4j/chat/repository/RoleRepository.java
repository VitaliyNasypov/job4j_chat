package ru.job4j.chat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.job4j.chat.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
