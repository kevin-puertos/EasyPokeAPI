package io.github.macebot.cobble_api.pokemon;

import io.github.macebot.cobble_api.pokemon.dto.*;
import io.github.macebot.cobble_api.pokemon.stats.StatsDto;
import tools.jackson.databind.JsonNode;

public interface IPokemonService {
    PokemonViewDetailDto viewPokemon(String pokemonName);
    PokemonSimpleDto viewSimplePokemon(String pokemonName);
    Boolean pokemonExistByName(String pokemonName);


    PokemonByType getPokemonByType(String type);
    Pokemon getPokemonById(Long id);
    Pokemon getPokemonByName(String name);
    void  loadPokemon(PokemonLoadDto pokemon);



    //JSON
    Pokemon processJson(String pokemonName);
    StatsDto processStats(JsonNode root);

}
