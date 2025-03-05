package org.example.boardgamestats.controller;

import org.example.boardgamestats.entity.UserEntity;
import org.example.boardgamestats.exception.UserAlreadyExistException;
import org.example.boardgamestats.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.example.boardgamestats.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/registration")
    public ResponseEntity registration(@RequestBody UserEntity user) {
        try {
            userService.registration(user);
            return ResponseEntity.ok().body("Пользователь \"" + user.getName() + "\" успешно сохранен");
        } catch (UserAlreadyExistException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @GetMapping()
    public ResponseEntity getById(@RequestParam Long userId) throws UserNotFoundException {
        try {
            return ResponseEntity.ok().body("Пользователь c id: " + userId + " найден: " + userService.getById(userId).getName());
        } catch (UserNotFoundException e) {
            throw new RuntimeException(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
}
