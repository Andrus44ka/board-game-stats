package org.example.boardgamestats.repository;

import org.example.boardgamestats.entity.GameEntity;
import org.example.boardgamestats.entity.PlayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<PlayerEntity, Long> {
}
