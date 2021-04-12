package ru.job4j.chat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.job4j.chat.model.Room;
import ru.job4j.chat.service.RoomService;

import java.util.List;

@RestController
@RequestMapping("chat/rooms")
public class RoomController {
    private final RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/")
    public List<Room> findAll() {
        return roomService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Room> findById(@PathVariable int id) {
        var person = roomService.findById(id);
        return new ResponseEntity<>(
                person.orElse(new Room()),
                person.isPresent() ? HttpStatus.OK : HttpStatus.NOT_FOUND
        );
    }

    @PostMapping("/{personFirstId}/{personSecondId}")
    public ResponseEntity<Room> create(@PathVariable int personFirstId,
                                       @PathVariable int personSecondId,
                                       @RequestBody Room room) {
        return new ResponseEntity<>(
                roomService.create(personFirstId, personSecondId, room),
                HttpStatus.CREATED
        );
    }

    @PutMapping("/{personAddId}")
    public ResponseEntity<Void> update(@PathVariable int personAddId, @RequestBody Room room) {
        roomService.update(personAddId, room);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        roomService.delete(id);
        return ResponseEntity.ok().build();
    }
}
