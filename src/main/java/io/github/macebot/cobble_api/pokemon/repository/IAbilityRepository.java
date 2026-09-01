package io.github.macebot.cobble_api.pokemon.repository;

import io.github.macebot.cobble_api.pokemon.entity.Ability;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAbilityRepository extends JpaRepository<Ability,Long> {
}
