package io.github.macebot.cobble_api.pokemon.ids;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

@Data
@Embeddable
public class PokemonTypeId implements Serializable {
    @Column(name = "pokemon_id")
    private Long pokemonId;

    @Column(name = "type_id")
    private Long typeId;

    @Column(name = "slot")
    private  Integer slot;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PokemonTypeId that = (PokemonTypeId) o;
        return Objects.equals(pokemonId, that.pokemonId) && Objects.equals(typeId, that.typeId) && Objects.equals(slot, that.slot);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pokemonId, typeId, slot);
    }
}
