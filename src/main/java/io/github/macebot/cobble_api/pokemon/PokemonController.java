package io.github.macebot.cobble_api.pokemon;

import io.github.macebot.cobble_api.pokemon.dto.PokemonByType;
import io.github.macebot.cobble_api.pokemon.dto.PokemonSimpleDto;
import io.github.macebot.cobble_api.pokemon.dto.PokemonLoadDto;
import io.github.macebot.cobble_api.pokemon.dto.PokemonViewDetailDto;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/pokemons")
public class PokemonController {

    private final IPokemonService pokemonService;


    @GetMapping("/loadAllPokemons")
    public String loadAllPokemons() {
        pokemonService.loadAllPokemons();
        return "all Pokemons Loaded";
    }

    @GetMapping()
    public ArrayList<PokemonSimpleDto> getAllPokemons(){
        return pokemonService.getAllPokemons();
    }

    @GetMapping("/detail/{namePokemon:[a-zA-Z-]+}")
    public PokemonViewDetailDto viewDetailPokemonByName(@PathVariable String namePokemon) {
        return pokemonService.viewPokemon(namePokemon);
    }

    @GetMapping("/detail/{id:[0-9]+}")
    public PokemonViewDetailDto viewDetailPokemonById(@PathVariable Long id) {
        return pokemonService.pokemonById(id);
    }

    @GetMapping("/simple/{namePokemon:[a-zA-Z-]+}")
    public PokemonSimpleDto viewSimplePokemon(@PathVariable String namePokemon) {
        return pokemonService.viewSimplePokemonByName(namePokemon);
    }

    @GetMapping("/simple/{id:[0-9]+}")
    public PokemonSimpleDto viewSimplePokemonById(@PathVariable @Positive Long id) {
        return pokemonService.viewSimplePokemonByid(id);
    }

    @GetMapping("/type/{type}")
    public PokemonByType pokemonByType(@PathVariable String type) {
        return pokemonService.getPokemonByType(type);
    }


}
