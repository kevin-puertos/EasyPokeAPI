package io.github.macebot.cobble_api.pokemon.service;

import io.github.macebot.cobble_api.pokemon.dto.PokemonViewDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
@RequiredArgsConstructor
public class PokemonService implements IPokemonService{

    private final RestClient restClient;

    @Override
    public PokemonViewDto viewPokemon(String pokemonName) {
        return  restClient
                .get()
                .uri("/pokemon/{pokemonName}",pokemonName)
                .retrieve()
                .body(PokemonViewDto.class);
    }
}
