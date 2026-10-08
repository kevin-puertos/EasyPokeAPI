package io.github.macebot.cobble_api.pokemon.movements;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IMovementRepository extends JpaRepository<Movement,Long> {
    Boolean existsByName(String name);
}
