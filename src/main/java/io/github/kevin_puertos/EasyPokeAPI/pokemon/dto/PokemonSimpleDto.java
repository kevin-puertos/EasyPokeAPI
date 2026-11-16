package io.github.kevin_puertos.EasyPokeAPI.pokemon.dto;

import io.github.kevin_puertos.EasyPokeAPI.pokemon.stats.StatsDto;
import io.github.kevin_puertos.EasyPokeAPI.pokemon.type.TypeDto;

import java.util.List;

public record PokemonSimpleDto(
        Long id,
        String name,
        String image_url,
        StatsDto stats,
        List<TypeDto> types
) {
}
