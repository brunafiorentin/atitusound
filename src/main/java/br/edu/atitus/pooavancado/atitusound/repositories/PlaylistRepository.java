package br.edu.atitus.pooavancado.atitusound.repositories;

import br.edu.atitus.pooavancado.atitusound.entities.PlaylistEntity;

import br.edu.atitus.pooavancado.atitusound.entities.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaylistRepository extends GenericRepository<PlaylistEntity>{

    Page<List<PlaylistEntity>> findByNameContainingIgnoreCaseAndUserOrPublicshare(Pageable pageable, String name, UserEntity user, boolean publicshare);
}
