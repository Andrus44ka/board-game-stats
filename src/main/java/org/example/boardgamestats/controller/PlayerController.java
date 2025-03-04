package org.example.boardgamestats.controller;

import org.example.boardgamestats.entity.PlayerEntity;
import org.example.boardgamestats.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/players")
public class PlayerController {
    @Autowired
    private PlayerRepository playerRepository;

    @GetMapping
    public List<PlayerEntity> getPlayers() { return playerRepository.findAll(); }

    @PostMapping
    public PlayerEntity createPlayer(@RequestBody PlayerEntity player) {return playerRepository.save(player); }

    @PostMapping("/batch")
    public ResponseEntity<List<PlayerEntity>> createPlayers(@RequestBody List<PlayerEntity> players) {
        List<PlayerEntity> savedPlayers = playerRepository.saveAll(players);
        return ResponseEntity.ok(savedPlayers);
    }
}
