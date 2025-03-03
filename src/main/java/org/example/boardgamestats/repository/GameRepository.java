package org.example.boardgamestats.repository;

import org.example.boardgamestats.entity.GameEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<GameEntity, Long> {
}
