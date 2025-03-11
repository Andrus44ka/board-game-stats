package org.example.boardgamestats.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Locations")
public class LocationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<GameSessionEntity> gameSessions;

    public LocationEntity() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGameSessions(List<GameSessionEntity> gameSessions) {
        this.gameSessions = gameSessions;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<GameSessionEntity> getGameSessions() {
        return gameSessions;
    }
}
