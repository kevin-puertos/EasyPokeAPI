package io.github.macebot.cobble_api.pokemon;

import io.github.macebot.cobble_api.pokemon.dto.*;
import io.github.macebot.cobble_api.pokemon.stats.StatsDto;
import tools.jackson.databind.JsonNode;

public interface IPokemonService {
    PokemonViewDetailDto viewPokemon(String pokemonName);
    PokemonSimpleDto viewSimplePokemon(String pokemonName);
    PokemonSimpleDto viewSimplePokemonByid (Long id);

    Boolean pokemonExistByName(String pokemonName);
    Boolean pokemonExistById(Long Id);
    PokemonLoadDto createPokemonLoadDto(String json);

    PokemonByType getPokemonByType(String type);
    Pokemon getPokemonById(Long id);
    Pokemon getPokemonByName(String name);
    PokemonViewDetailDto pokemonById(Long id);
    void  loadPokemon(PokemonLoadDto pokemon);



    //JSON
    Pokemon pokemonByName(String pokemonName);
    StatsDto processStats(JsonNode root);

}
