package io.github.macebot.cobble_api.pokemon.dto;

import java.util.List;

public record PokemonByType(
        String name,
        List<PokemonWithTypeDto> pokemonWithTypeDtoList) { }
