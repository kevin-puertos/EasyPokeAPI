package io.github.macebot.cobble_api.pokemon.repository;

import io.github.macebot.cobble_api.pokemon.entity.Movment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMovmentRepository extends JpaRepository<Movment,Long> {
}
