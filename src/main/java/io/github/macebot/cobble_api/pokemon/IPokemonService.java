package io.github.macebot.cobble_api.pokemon;

import io.github.macebot.cobble_api.pokemon.ability.AbilityDto;
import io.github.macebot.cobble_api.pokemon.dto.*;
import io.github.macebot.cobble_api.pokemon.movements.MovementDto;
import io.github.macebot.cobble_api.pokemon.stats.StatsDto;
import tools.jackson.databind.JsonNode;

import java.util.List;

public interface IPokemonService {
    PokemonViewDto viewPokemon(String pokemonName);
    PokemonByType getPokemonByType(String type);
    Pokemon getPokemon(Long id);
    void  loadPokemon(PokemonViewDto pokemon);



    //JSON
    PokemonViewDto processJson(String pokemonName);
    StatsDto processStats(JsonNode root);

}
