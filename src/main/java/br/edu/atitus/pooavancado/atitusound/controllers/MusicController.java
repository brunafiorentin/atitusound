package br.edu.atitus.pooavancado.atitusound.controllers;

import br.edu.atitus.pooavancado.atitusound.entities.ArtistEntity;
import br.edu.atitus.pooavancado.atitusound.entities.MusicEntity;
import br.edu.atitus.pooavancado.atitusound.entities.dtos.MusicDTO;
import br.edu.atitus.pooavancado.atitusound.services.GenericService;
import br.edu.atitus.pooavancado.atitusound.services.MusicService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/musics")
public abstract class MusicController extends GenericController<MusicEntity, MusicDTO> {

    private final MusicService service;

    public MusicController(MusicService service) {
        this.service = service;
    }

    @Override
    protected GenericService<MusicEntity> getService() {
        return service;
    }

    @GetMapping
    public ResponseEntity<List<MusicEntity>> getAll() throws Exception {
        List<MusicEntity> musicEntities = service.findAll();

        return ResponseEntity.ok(musicEntities);
    }

    @PostMapping
    public ResponseEntity<MusicEntity> create(@RequestBody MusicDTO dto) throws Exception {
        MusicEntity musicEntity = convertDTO2Entity(dto);

        service.save(musicEntity);

        return ResponseEntity.status(HttpStatus.CREATED).body(musicEntity);
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<MusicEntity> update(@PathVariable UUID uuid, @RequestBody MusicDTO dto) {
        MusicEntity musicEntity = convertDTO2Entity(dto);
        musicEntity.setUuid(uuid);

        try {
            service.save(musicEntity);
        } catch (Exception e) {
            return ResponseEntity.badRequest().header("error", e.getMessage()).build();
        }
        return ResponseEntity.ok(musicEntity);
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

    @Override
    protected MusicEntity convertDTO2Entity(MusicDTO dto) {
        MusicEntity entidade = new MusicEntity();
        entidade.setName(dto.getName());
        entidade.setDuration(dto.getDuration());
        entidade.setUrl(dto.getUrl());
        entidade.setLikes_count(dto.getLikes_count());
        return entidade;
    }
}
