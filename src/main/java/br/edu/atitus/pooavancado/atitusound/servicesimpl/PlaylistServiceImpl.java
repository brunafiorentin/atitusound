package br.edu.atitus.pooavancado.atitusound.servicesimpl;

import br.edu.atitus.pooavancado.atitusound.entities.PlaylistEntity;
import br.edu.atitus.pooavancado.atitusound.repositories.GenericRepository;
import br.edu.atitus.pooavancado.atitusound.services.PlaylistService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class PlaylistServiceImpl implements PlaylistService {
    @Override
    public GenericRepository<PlaylistEntity> getRepository() {
        return null;
    }

    @Override
    public void validate(PlaylistEntity playlistEntity) throws Exception {
        PlaylistService.super.validate(playlistEntity);
    }

    @Override
    public PlaylistEntity save(PlaylistEntity playlistEntity) throws Exception {
        return PlaylistService.super.save(playlistEntity);
    }

    @Override
    public List<PlaylistEntity> findAll() throws Exception {
        return PlaylistService.super.findAll();
    }

    @Override
    public Optional<PlaylistEntity> findById(UUID uuid) throws Exception {
        return PlaylistService.super.findById(uuid);
    }

    @Override
    public void deleteById(UUID uuid) throws Exception {
        PlaylistService.super.deleteById(uuid);
    }

    @Override
    public Page<List<PlaylistEntity>> findByNameContainingIgnoreCase(Pageable pageable, String name) throws Exception {
        return PlaylistService.super.findByNameContainingIgnoreCase(pageable, name);
    }
}
