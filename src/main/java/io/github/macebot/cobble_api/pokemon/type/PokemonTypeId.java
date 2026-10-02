package io.github.macebot.cobble_api.pokemon.type;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@Data
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class PokemonTypeId implements Serializable {
    @Column(name = "pokemon_id")
    private Long pokemonId;

    @Column(name = "type_name")
    private String typeName;

    @Column(name = "slot")
    private  Integer slot;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PokemonTypeId that = (PokemonTypeId) o;
        return Objects.equals(pokemonId, that.pokemonId) && Objects.equals(typeName, that.typeName) && Objects.equals(slot, that.slot);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pokemonId, typeName, slot);
    }
}
