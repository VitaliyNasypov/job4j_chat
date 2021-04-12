package ru.job4j.chat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.job4j.chat.model.Role;
import ru.job4j.chat.repository.RoleRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {
    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    public Optional<Role> findById(int id) {
        return roleRepository.findById(id);
    }

    public Role create(Role role) {
        return roleRepository.save(role);
    }

    public void update(Role role) {
        roleRepository.save(role);
    }

    public void delete(int id) {
        roleRepository.deleteById(id);
    }
}
