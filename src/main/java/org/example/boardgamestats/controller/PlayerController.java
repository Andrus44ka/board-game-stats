package org.example.boardgamestats.controller;

import org.example.boardgamestats.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/player")
public class PlayerController {
    @Autowired
    private PlayerRepository playerRepository;


}
