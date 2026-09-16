package io.github.macebot.cobble_api.client.service;

import org.springframework.stereotype.Service;
import tools.jackson.databind.JsonNode;

public interface IPokeApiClient {
    String getPokemonJson(String pokemonName);
    String getTypeJson(String type);
    JsonNode getMoveJson(String move);

}
