package io.github.macebot.cobble_api.pokemon.dto;

import io.github.macebot.cobble_api.pokemon.stats.StatsDto;
import io.github.macebot.cobble_api.pokemon.type.TypeDto;

import java.util.List;

public record PokemonSimpleDto(
        Long id,
        String name,
        String image_url,
        StatsDto stats,
        List<TypeDto> types
) {
}
