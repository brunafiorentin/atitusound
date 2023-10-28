package br.edu.atitus.pooavancado.atitusound.entities.dtos;

import java.util.UUID;

public class PlaylistDTO {

    private UUID uuid;

    private String name;

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
