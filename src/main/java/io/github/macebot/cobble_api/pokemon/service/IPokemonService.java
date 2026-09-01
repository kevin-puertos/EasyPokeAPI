package io.github.macebot.cobble_api.pokemon.service;

import io.github.macebot.cobble_api.pokemon.dto.*;
import io.github.macebot.cobble_api.pokemon.entity.Pokemon;
import tools.jackson.databind.JsonNode;

import java.util.List;

public interface IPokemonService {
    PokemonViewDto viewPokemon(String pokemonName);
    PokemonByType getPokemonByType(String type);

    PokemonViewDto loadPokemon(Pokemon pokemon);
    PokemonViewDto processJson(String pokemonName);

    String getPokemonJson(String pokemonName);
    String getTypeJson(String type);





    List<AbilityDto> processAbilities( JsonNode root,String json);
    List<StatDto> processStats(JsonNode root,String json);
    List<TypeDto> processTypes(JsonNode root,String json);


}
