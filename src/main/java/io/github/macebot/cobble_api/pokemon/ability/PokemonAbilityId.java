package io.github.macebot.cobble_api.pokemon.ability;

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
public class PokemonAbilityId implements Serializable {
    @Column(name ="pokemon_id")
    private Long pokemonId;

    private Integer slot;
    private Boolean is_hidden;

    @Column(name="ability_name")
    private String abilityName;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PokemonAbilityId that = (PokemonAbilityId) o;
        return Objects.equals(pokemonId, that.pokemonId) && Objects.equals(slot, that.slot) && Objects.equals(is_hidden, that.is_hidden) && Objects.equals(abilityName, that.abilityName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pokemonId, slot, is_hidden, abilityName);
    }
}
