package org.example.boardgamestats.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Games")
public class GameEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "session")
    private List<GameSessionEntity> sessions;

    public GameEntity() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSessions(List<GameSessionEntity> sessions) {
        this.sessions = sessions;
    }

    public List<GameSessionEntity> getSessions() {
        return sessions;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

}