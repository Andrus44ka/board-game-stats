package org.example.boardgamestats.repository;

import org.example.boardgamestats.entity.GameEntity;
import org.example.boardgamestats.entity.GameSessionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameSessionRepository extends JpaRepository<GameSessionEntity, Long> {
//    List<GameSessionEntity> findByOwnerId(Long id);
}
