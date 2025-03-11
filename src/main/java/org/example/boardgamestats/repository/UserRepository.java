package org.example.boardgamestats.repository;

import org.example.boardgamestats.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findUserEntityByName(String name);
}
