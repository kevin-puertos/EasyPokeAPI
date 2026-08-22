package io.github.macebot.cobble_api.pokemon.controller;

import io.github.macebot.cobble_api.pokemon.dto.PokemonByType;
import io.github.macebot.cobble_api.pokemon.dto.PokemonViewDto;
import io.github.macebot.cobble_api.pokemon.service.IPokemonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PokemonController {

    private final IPokemonService pokemonService;


    @GetMapping("/pokemon/{namePokemon}")
    public PokemonViewDto viewPokemon(@PathVariable String namePokemon){
        return pokemonService.viewPokemon(namePokemon);
    }


    @GetMapping("/type/{type}")
    public PokemonByType pokemonByType(@PathVariable String type){

        return  pokemonService.getPokemonByType(type);
    }


}
