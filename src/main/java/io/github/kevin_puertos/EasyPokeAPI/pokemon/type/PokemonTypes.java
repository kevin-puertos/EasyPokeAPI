package io.github.kevin_puertos.EasyPokeAPI.pokemon.type;

import io.github.kevin_puertos.EasyPokeAPI.pokemon.Pokemon;
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
    private Pokemon pokemon = new Pokemon();

    @ManyToOne
    @MapsId("typeName")
    @JoinColumn(name = "type_name")
    private Type type = new Type();



}
