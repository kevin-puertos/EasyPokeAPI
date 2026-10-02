package io.github.macebot.cobble_api.client.service;

import io.github.macebot.cobble_api.exception.exeptions.ResourceNotFound;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import tools.jackson.databind.JsonNode;

@Service
@RequiredArgsConstructor
public class PokeApiClient implements IPokeApiClient {

    private final RestClient restClient;

    @Override
    public String getPokemonJson(String pokemonName) {
        return  restClient
                .get()
                .uri("/pokemon/{pokemonName}",pokemonName)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError,
                        ((request, response) ->
                        {throw new ResourceNotFound("Pokemon not found");}))
                .body(String.class);

    }

    @Override
    public String getTypeJson(String type) {
        return  restClient
                .get()
                .uri("/type/{type}",type)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError,
                        ((request, response) ->
                        {throw new ResourceNotFound("Type not found");}))
                .body(String.class);

    }

    @Override
    public JsonNode getMoveJson(String move) {
        return  restClient
                .get()
                .uri("/move/{move}",move)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError,
                        ((request, response) ->
                        {throw new ResourceNotFound("Move not found");}))
                .body(JsonNode.class);
    }

    @Override
    public JsonNode getAbiltyJson(String name) {
        return  restClient
                .get()
                .uri("/ability/{name}",name)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError,
                        ((request, response) ->
                        {throw new ResourceNotFound("Ability not found");}))
                .body(JsonNode.class);
    }
}
