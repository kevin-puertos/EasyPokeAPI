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

    @MapsId("pokemonId")
    @ManyToOne
    @JoinColumn(name ="pokemon_id")
    private Pokemon pokemon;

    @MapsId("typeId")
    @ManyToOne
    @JoinColumn(name = "type_id")
    private Type type;


}
