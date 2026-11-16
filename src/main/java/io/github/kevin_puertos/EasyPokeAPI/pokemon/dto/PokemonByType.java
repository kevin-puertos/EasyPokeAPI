package io.github.kevin_puertos.EasyPokeAPI.pokemon.dto;

import java.util.List;

public record PokemonByType(
        String name,
        List<PokemonWithTypeDto> pokemonWithTypeDtoList) { }
