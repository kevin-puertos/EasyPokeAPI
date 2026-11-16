package io.github.kevin_puertos.EasyPokeAPI.client.service;

import tools.jackson.databind.JsonNode;

public interface IPokeApiClient {

    String getPokemonJsonByName(String pokemonName);
    String getPokemonJsonById(Long id);
    String getTypeJson(String type);
    String getAllPokemons();
    JsonNode getMoveJson(String move);
    JsonNode getAbiltyJson(String name);

}
