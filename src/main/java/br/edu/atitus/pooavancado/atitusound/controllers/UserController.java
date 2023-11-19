package br.edu.atitus.pooavancado.atitusound.controllers;

import br.edu.atitus.pooavancado.atitusound.entities.GenericEntity;
import br.edu.atitus.pooavancado.atitusound.entities.UserEntity;
import br.edu.atitus.pooavancado.atitusound.entities.dtos.UserDTO;
import br.edu.atitus.pooavancado.atitusound.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public abstract class UserController<TEntidade extends GenericEntity, TDTO> {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserEntity>> getAll() throws Exception {
        List<UserEntity> users = userService.findAll();

        return ResponseEntity.ok(users);
    }

    @PostMapping
    public ResponseEntity<UserEntity> create (@RequestBody UserDTO dto) {
        UserEntity user = convertDTO2Entity(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<UserEntity> update(@PathVariable UUID uuid, @RequestBody UserDTO dto) {
        UserEntity userEntity = convertDTO2Entity(dto);
        userEntity.setUuid(uuid);

        try {
            userService.save(userEntity);
        } catch (Exception e) {
            return ResponseEntity.badRequest().header("error", e.getMessage()).build();
        }
        return ResponseEntity.ok(userEntity);
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<?> delete(@PathVariable UUID uuid) {
        try {
            userService.deleteById(uuid);
        } catch (Exception e) {
            return ResponseEntity.badRequest().header("error", e.getMessage()).build();
        }
        return ResponseEntity.ok().build();

    }

    private UserEntity convertDTO2Entity(UserDTO dto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(dto.getEmail());
        userEntity.setName(dto.getName());
        userEntity.setPassword(dto.getPassword());

        return userEntity;
    }
}
