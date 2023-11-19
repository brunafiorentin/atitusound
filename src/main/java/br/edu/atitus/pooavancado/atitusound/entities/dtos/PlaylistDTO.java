package br.edu.atitus.pooavancado.atitusound.entities.dtos;

import java.util.UUID;

public class PlaylistDTO {


    private String name;

    private boolean public_share;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getPublic_share() {
        return public_share;
    }

    public void setPublic_share(boolean public_share) {
        this.public_share = public_share;
    }
}
