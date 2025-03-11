package org.example.boardgamestats.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "GameSessions")
public class GameSessionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "gameId", nullable = false)
    private GameEntity game;

    @ManyToOne
    @JoinColumn(name = "locationId")
    private LocationEntity location;

    @Column(name = "startTime")
    private LocalDateTime startTime;

    @Column(name = "endTime")
    private LocalDateTime endTime;

    @Column(name = "dayOfWeek")
    private String dayOfWeek;

    @OneToMany(mappedBy = "session", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PlayerResultEntity> playerResultEntities;

    public GameSessionEntity() {}

    public LocationEntity getLocation() {
        return location;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public List<PlayerResultEntity> getPlayerResultEntities() {
        return playerResultEntities;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setGame(GameEntity game) {
        this.game = game;
    }


    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public Long getId() {
        return id;
    }

    public GameEntity getGame() {
        return game;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }
}
