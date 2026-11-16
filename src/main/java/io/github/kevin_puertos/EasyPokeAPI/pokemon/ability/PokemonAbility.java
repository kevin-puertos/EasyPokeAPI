package io.github.kevin_puertos.EasyPokeAPI.pokemon.ability;

import io.github.kevin_puertos.EasyPokeAPI.pokemon.Pokemon;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class PokemonAbility {
    @EmbeddedId
    private PokemonAbilityId pokemonAbilityId;

    @ManyToOne
    @MapsId("pokemonId")
    @JoinColumn(name = "pokemon_id")
    private Pokemon pokemon;


    @ManyToOne
    @MapsId("abilityName")
    @JoinColumn(name = "ability_name")
    private Ability ability;

}
