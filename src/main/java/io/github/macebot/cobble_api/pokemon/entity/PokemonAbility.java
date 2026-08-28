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

    @MapsId("pokemon_id")
    @ManyToOne
    @JoinColumn(name = "pokemon_id")
    private Pokemon pokemon;


    @MapsId("ability_id")
    @ManyToOne
    @JoinColumn(name = "ability_id")
    private Ability ability;

}
