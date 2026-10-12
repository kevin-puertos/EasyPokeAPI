package io.github.macebot.cobble_api.pokemon;

import io.github.macebot.cobble_api.pokemon.dto.PokemonByType;
import io.github.macebot.cobble_api.pokemon.dto.PokemonSimpleDto;
import io.github.macebot.cobble_api.pokemon.dto.PokemonLoadDto;
import io.github.macebot.cobble_api.pokemon.dto.PokemonViewDetailDto;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PokemonController {

    private final IPokemonService pokemonService;


    @GetMapping("/pokemonDetailByName/{namePokemon}")
    public PokemonViewDetailDto viewDetailPokemonByName(@PathVariable String namePokemon) {
        return pokemonService.viewPokemon(namePokemon);
    }

    @GetMapping("/pokemonSimpleByName/{namePokemon}")
    public PokemonSimpleDto viewSimplePokemon(@PathVariable String namePokemon) {
        return pokemonService.viewSimplePokemonByName(namePokemon);
    }

    @GetMapping("/pokemonDetailById/{id}")
    public PokemonViewDetailDto viewDetailPokemonById(@PathVariable Long id) {
        return pokemonService.pokemonById(id);
    }


    @GetMapping("/pokemonSimpleById/{id}")
    public PokemonSimpleDto viewSimplePokemonById(@PathVariable @Positive Long id) {
        return pokemonService.viewSimplePokemonByid(id);
    }

    @GetMapping("/type/{type}")
    public PokemonByType pokemonByType(@PathVariable String type) {
        return pokemonService.getPokemonByType(type);
    }


}
