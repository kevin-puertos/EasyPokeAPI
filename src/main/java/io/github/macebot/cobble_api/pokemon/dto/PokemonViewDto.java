package io.github.macebot.cobble_api.pokemon.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PokemonViewDto(
        Long id,
        String name,
        List<TypeDto> types,
        List<AbilityDto> abilities,
        List<StatDto> stats

) {
}
