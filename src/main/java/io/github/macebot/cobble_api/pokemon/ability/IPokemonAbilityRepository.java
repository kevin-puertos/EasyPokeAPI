package io.github.macebot.cobble_api.pokemon.ability;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPokemonAbilityRepository extends JpaRepository<PokemonAbility,PokemonAbilityId> {
}
