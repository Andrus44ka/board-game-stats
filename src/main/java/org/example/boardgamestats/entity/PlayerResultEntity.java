package org.example.boardgamestats.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "PlayerResult")
public class PlayerResultEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sessionId", nullable = false)
    private GameSessionEntity session;

    @ManyToOne
    @JoinColumn(name = "playerId", nullable = false)
    private PlayerEntity player;

    @Column(name = "position", nullable = false)
    private Integer position;

    public PlayerResultEntity() {
    }

    public void setSession(GameSessionEntity session) {
        this.session = session;
    }

    public void setPlayer(PlayerEntity player) {
        this.player = player;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Integer getPosition() {
        return position;
    }

    public PlayerEntity getPlayer() {
        return player;
    }

    public GameSessionEntity getSession() {
        return session;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
