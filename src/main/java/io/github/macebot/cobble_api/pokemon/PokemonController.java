package io.github.macebot.cobble_api.pokemon;

import io.github.macebot.cobble_api.pokemon.dto.PokemonByType;
import io.github.macebot.cobble_api.pokemon.dto.PokemonSimpleDto;
import io.github.macebot.cobble_api.pokemon.dto.PokemonLoadDto;
import io.github.macebot.cobble_api.pokemon.dto.PokemonViewDetailDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PokemonController {

    private final IPokemonService pokemonService;


    @GetMapping("/pokemonDetail/{namePokemon}")
    public PokemonViewDetailDto viewPokemon(@PathVariable String namePokemon){
        return pokemonService.viewPokemon(namePokemon);
    }

    @GetMapping("/pokemonSimple/{namePokemon}")
    public PokemonSimpleDto viewSimplePokemon(@PathVariable String namePokemon){
       return pokemonService.viewSimplePokemon(namePokemon);
    }

    @GetMapping("/type/{type}")
    public PokemonByType pokemonByType(@PathVariable String type){
        return  pokemonService.getPokemonByType(type);
    }


}
