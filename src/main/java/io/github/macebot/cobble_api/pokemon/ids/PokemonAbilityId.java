package io.github.macebot.cobble_api.pokemon.ids;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

@Data
@Embeddable
public class PokemonAbilityId implements Serializable {

    @Column(name="pokemon_id")
    private Long pokemonId;

    @Column(name = "ability_id")
    private Long abilityId;

    @Column(name = "is_hidden")
    private Boolean isHidden;

    @Column(name = "slot")
    private  Integer slot;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PokemonAbilityId that = (PokemonAbilityId) o;
        return Objects.equals(pokemonId, that.pokemonId) && Objects.equals(abilityId, that.abilityId) && Objects.equals(isHidden, that.isHidden) && Objects.equals(slot, that.slot);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pokemonId, abilityId, isHidden, slot);
    }
}
