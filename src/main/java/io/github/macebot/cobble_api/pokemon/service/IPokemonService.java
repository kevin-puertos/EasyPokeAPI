package io.github.macebot.cobble_api.pokemon.service;

import io.github.macebot.cobble_api.pokemon.dto.*;
import io.github.macebot.cobble_api.pokemon.entity.Pokemon;
import tools.jackson.databind.JsonNode;

import java.util.List;

public interface IPokemonService {
    PokemonViewDto viewPokemon(String pokemonName);
    PokemonByType getPokemonByType(String type);

    void  loadPokemon(PokemonViewDto pokemon);
    PokemonViewDto processJson(String pokemonName);



    List<MovmentDto> processMovments(JsonNode root);
    List<AbilityDto> processAbilities( JsonNode root);
    StatsDto processStats(JsonNode root);
    List<TypeDto> processTypes(JsonNode root);


}
