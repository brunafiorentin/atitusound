package br.edu.atitus.pooavancado.atitusound.entities;

import jakarta.persistence.*;

import java.time.Duration;
import java.util.UUID;

@Entity
@Table(name = "playlist")
public class PlaylistEntity extends GenericEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Boolean public_share;

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getPublic_share() {
        return public_share;
    }

    public void setPublic_share(Boolean public_share) {
        this.public_share = public_share;
    }
}
