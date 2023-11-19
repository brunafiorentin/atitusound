package br.edu.atitus.pooavancado.atitusound.entities;

import jakarta.persistence.*;

import java.time.Duration;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tb_playlist")
public class PlaylistEntity extends GenericEntity{

    @Column(nullable = false, name = "public_share")
    private boolean publicshare;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tb_playlist_music",
            joinColumns = @JoinColumn(name = "playlist_uuid"),
            inverseJoinColumns = @JoinColumn(name = "music_uuid"))
    private List<MusicEntity> musics;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_uuid", nullable = false)
    private UserEntity user;


    public boolean getPublic_share() {
        return publicshare;
    }

    public void setPublic_share(boolean public_share) {
        this.publicshare = public_share;
    }

    public List<MusicEntity> getMusics() {
        return musics;
    }

    public void setMusics(List<MusicEntity> musics) {
        this.musics = musics;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
