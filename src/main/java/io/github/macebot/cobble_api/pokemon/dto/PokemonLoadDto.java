package io.github.macebot.cobble_api.pokemon.dto;


import io.github.macebot.cobble_api.pokemon.ability.AbilityDto;
import io.github.macebot.cobble_api.pokemon.movements.MovementDto;
import io.github.macebot.cobble_api.pokemon.stats.StatsDto;
import io.github.macebot.cobble_api.pokemon.type.TypeDto;

import java.util.List;

public record PokemonLoadDto(
        Long id,
        String name,
        String image_url,
        List<TypeDto> types,
        List<AbilityDto> abilities,
        StatsDto stats,
        List<MovementDto> movements
) {
}
