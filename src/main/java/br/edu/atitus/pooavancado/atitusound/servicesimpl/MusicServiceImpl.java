package br.edu.atitus.pooavancado.atitusound.servicesimpl;

import br.edu.atitus.pooavancado.atitusound.entities.MusicEntity;
import br.edu.atitus.pooavancado.atitusound.repositories.GenericRepository;
import br.edu.atitus.pooavancado.atitusound.repositories.MusicRepository;
import br.edu.atitus.pooavancado.atitusound.services.MusicService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MusicServiceImpl implements MusicService {


    public MusicRepository musicRepository;

    @Override
    public GenericRepository<MusicEntity> getRepository() {
        return null;
    }

    @Override
    public void validate(MusicEntity musicEntity) throws Exception {
        MusicService.super.validate(musicEntity);
    }

    @Override
    public MusicEntity save(MusicEntity musicEntity) throws Exception {
        return MusicService.super.save(musicEntity);
    }

    @Override
    public List<MusicEntity> findAll() throws Exception {
        return musicRepository.findAll();
    }

    @Override
    public Optional<MusicEntity> findById(UUID uuid) throws Exception {
        return MusicService.super.findById(uuid);
    }

    @Override
    public void deleteById(UUID uuid) throws Exception {
        MusicService.super.deleteById(uuid);
    }

    @Override
    public Page<List<MusicEntity>> findByNameContainingIgnoreCase(Pageable pageable, String name) throws Exception {
        return MusicService.super.findByNameContainingIgnoreCase(pageable, name);
    }

}
