package io.github.macebot.cobble_api.pokemon.entity;

import io.github.macebot.cobble_api.pokemon.ids.PokemonTypeId;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class PokemonTypes {
    @EmbeddedId
    private PokemonTypeId pokemonTypeId;

    @ManyToOne
    @MapsId("pokemonId")
    @JoinColumn(name ="pokemon_id")
    private Pokemon pokemon;

    @ManyToOne
    @MapsId("typeName")
    @JoinColumn(name = "type_name")
    private Type type;



}
