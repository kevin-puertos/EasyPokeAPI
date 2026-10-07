package io.github.macebot.cobble_api.client.service;

import org.springframework.stereotype.Service;
import tools.jackson.databind.JsonNode;

public interface IPokeApiClient {
    String getPokemonJsonByName(String pokemonName);
    String getPokemonJsonById(Long id);
    String getTypeJson(String type);
    JsonNode getMoveJson(String move);
    JsonNode getAbiltyJson(String name);

}
