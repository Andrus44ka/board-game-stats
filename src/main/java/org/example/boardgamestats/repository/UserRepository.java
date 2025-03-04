package org.example.boardgamestats.repository;

import org.example.boardgamestats.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
