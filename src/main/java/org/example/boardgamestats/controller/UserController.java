package org.example.boardgamestats.controller;

import org.example.boardgamestats.entity.UserEntity;
import org.example.boardgamestats.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/players")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<UserEntity> getPlayers() { return userRepository.findAll(); }

    @PostMapping
    public UserEntity createPlayer(@RequestBody UserEntity player) {return userRepository.save(player); }

    @PostMapping("/batch")
    public ResponseEntity<List<UserEntity>> createPlayers(@RequestBody List<UserEntity> players) {
        List<UserEntity> savedPlayers = userRepository.saveAll(players);
        return ResponseEntity.ok(savedPlayers);
    }
}
