package io.github.kevin_puertos.EasyPokeAPI.pokemon;

import io.github.kevin_puertos.EasyPokeAPI.pokemon.dto.PokemonByType;
import io.github.kevin_puertos.EasyPokeAPI.pokemon.dto.PokemonLoadDto;
import io.github.kevin_puertos.EasyPokeAPI.pokemon.dto.PokemonSimpleDto;
import io.github.kevin_puertos.EasyPokeAPI.pokemon.dto.PokemonViewDetailDto;
import io.github.kevin_puertos.EasyPokeAPI.pokemon.stats.StatsDto;
import tools.jackson.databind.JsonNode;
import java.util.ArrayList;

public interface IPokemonService {

    //Funciones de los endpoints principales
    PokemonSimpleDto viewSimplePokemonByName(String pokemonName);
    PokemonSimpleDto viewSimplePokemonByid (Long id);
    PokemonViewDetailDto pokemonViewDetailDtoById(Long id);
    PokemonViewDetailDto viewPokemon(String pokemonName);
    PokemonByType getPokemonByType(String type);
    ArrayList<PokemonSimpleDto> getAllPokemons();

    //Funciones Auxiliares
    Boolean pokemonExistByName(String pokemonName);
    Boolean pokemonExistById(Long Id);
    PokemonLoadDto createPokemonLoadDto(String json);
    Pokemon getPokemonById(Long id);
    Pokemon getPokemonByName(String name);
    void  loadPokemon(PokemonLoadDto pokemon);
    void loadAllPokemons();
    Pokemon pokemonByName(String pokemonName);
    StatsDto processStats(JsonNode root);

}

