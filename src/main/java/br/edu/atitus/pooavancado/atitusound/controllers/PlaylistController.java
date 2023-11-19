package br.edu.atitus.pooavancado.atitusound.controllers;

import br.edu.atitus.pooavancado.atitusound.entities.PlaylistEntity;
import br.edu.atitus.pooavancado.atitusound.entities.dtos.PlaylistDTO;
import br.edu.atitus.pooavancado.atitusound.services.GenericService;
import br.edu.atitus.pooavancado.atitusound.services.PlaylistService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/playlists")
public abstract class PlaylistController extends GenericController<PlaylistEntity, PlaylistDTO> {
    private final PlaylistService service;

    public PlaylistController(PlaylistService service) {
        super();
        this.service = service;
    }

    @Override
    protected GenericService<PlaylistEntity> getService() {
        return service;
    }

    @GetMapping
    public ResponseEntity<List<PlaylistEntity>> getAll() throws Exception {
        List<PlaylistEntity> playlistEntities = service.findAll();

        return ResponseEntity.ok(playlistEntities);
    }

    @PostMapping
    public ResponseEntity<PlaylistEntity> create(@RequestBody PlaylistDTO dto) throws Exception {
        PlaylistEntity playlistEntity = convertDTO2Entity(dto);

        service.save(playlistEntity);

        return ResponseEntity.status(HttpStatus.CREATED).body(playlistEntity);
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<PlaylistEntity> update(@PathVariable UUID uuid, @RequestBody PlaylistDTO dto) {
        PlaylistEntity playlistEntity = convertDTO2Entity(dto);
        playlistEntity.setUuid(uuid);

        try {
            service.save(playlistEntity);
        } catch (Exception e) {
            return ResponseEntity.badRequest().header("error", e.getMessage()).build();
        }
        return ResponseEntity.ok(playlistEntity);
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<?> delete(@PathVariable UUID uuid) {
        try {
            service.deleteById(uuid);
        } catch (Exception e) {
            return ResponseEntity.badRequest().header("error", e.getMessage()).build();
        }
        return ResponseEntity.ok().build();

    }

    protected PlaylistEntity convertDTO2Entity(PlaylistDTO dto) {
        PlaylistEntity playlist = new PlaylistEntity();
        playlist.setName(dto.getName());
        playlist.setPublic_share(dto.getPublic_share());
        return playlist;
    }
}
