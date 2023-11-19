package br.edu.atitus.pooavancado.atitusound.servicesimpl;

import br.edu.atitus.pooavancado.atitusound.entities.PlaylistEntity;
import br.edu.atitus.pooavancado.atitusound.entities.UserEntity;
import br.edu.atitus.pooavancado.atitusound.repositories.GenericRepository;
import br.edu.atitus.pooavancado.atitusound.repositories.PlaylistRepository;
import br.edu.atitus.pooavancado.atitusound.services.PlaylistService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PlaylistServiceImpl implements PlaylistService {

    private final PlaylistRepository repository;

    public PlaylistServiceImpl(PlaylistRepository repository) {
        super();
        this.repository = repository;
    }

    @Override
    public GenericRepository<PlaylistEntity> getRepository() {
        return repository;
    }

    @Override
    public void validate(PlaylistEntity entity) throws Exception {
        PlaylistService.super.validate(entity);
        UserEntity user = (UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        entity.setUser(user);
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
        UserEntity user = (UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return repository.findByNameContainingIgnoreCaseAndUserOrPublicshare(pageable, name, user, true);
    }
}
