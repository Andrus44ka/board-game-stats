package org.example.boardgamestats.service;

import org.example.boardgamestats.entity.UserEntity;
import org.example.boardgamestats.exception.UserAlreadyExistException;
import org.example.boardgamestats.exception.UserNotFoundException;
import org.example.boardgamestats.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserEntity registration (UserEntity user) throws UserAlreadyExistException {
        if (userRepository.findUserEntityByName(user.getName()) != null) {
            throw new UserAlreadyExistException("Пользователь \"" + user.getName() + "\" уже существует");
        }
        return userRepository.save(user);
    }

    public UserEntity getById (Long id) throws UserNotFoundException {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("Пользователь с id: " + id + " не найден"));
    }
}
