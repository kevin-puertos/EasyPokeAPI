package io.github.kevin_puertos.EasyPokeAPI.pokemon.dto;

import io.github.kevin_puertos.EasyPokeAPI.pokemon.ability.AbilityDto;
import io.github.kevin_puertos.EasyPokeAPI.pokemon.movements.MovementDto;
import io.github.kevin_puertos.EasyPokeAPI.pokemon.stats.StatsDto;
import io.github.kevin_puertos.EasyPokeAPI.pokemon.type.TypeDto;

import java.util.List;

public record PokemonViewDetailDto(

        Long id,
        String name,
        String image_url,
        List<TypeDto> types,
        List<AbilityDto> abilities,
        StatsDto stats,
        List<MovementDto> movements

) {}
