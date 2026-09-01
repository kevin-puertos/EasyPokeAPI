package io.github.macebot.cobble_api.pokemon.entity;

import io.github.macebot.cobble_api.pokemon.ids.PokemonAbilityId;
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
