package org.example.boardgamestats.controller;

import org.example.boardgamestats.entity.GameEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.example.boardgamestats.repository.GameRepository;

import java.util.List;

@RestController
@RequestMapping("api/games")
public class GameController {
    @Autowired
    private GameRepository gameRepository;

    @GetMapping
    public List<GameEntity> getGames() {
        return gameRepository.findAll();
    }

    @PostMapping
    public GameEntity createGame(@RequestBody GameEntity game) {
        return gameRepository.save(game);
    }

    @PostMapping("/batch")
    public ResponseEntity<List<GameEntity>> createGames(@RequestBody List<GameEntity> games) {
        List<GameEntity> savedGames = gameRepository.saveAll(games);
        return ResponseEntity.ok(savedGames);
    }
}
