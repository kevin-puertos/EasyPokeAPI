package io.github.kevin_puertos.EasyPokeAPI.pokemon;

import io.github.kevin_puertos.EasyPokeAPI.pokemon.dto.PokemonByType;
import io.github.kevin_puertos.EasyPokeAPI.pokemon.dto.PokemonSimpleDto;
import io.github.kevin_puertos.EasyPokeAPI.pokemon.dto.PokemonViewDetailDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/pokemons")
@Tag(name ="Pokemon", description = "Operaciones relacionadas con la obtencion de pokemones")
public class PokemonController {

    private final IPokemonService pokemonService;

    @Operation(summary = "Cargar todos los pokemones", description = "Obtener todos los pokemones desde la poke-api y guardarlos en la base de datos")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "Todos los pokemones han sido cargados correctamente")
    })

    @GetMapping("/loadAll")
    public String loadAllPokemons() {
        pokemonService.loadAllPokemons();
        return "All Pokemons Loaded";
    }

    @Operation(summary = "Obtener todos los pokemones", description = "Obtener todos los pokemones desde la base de datos y retornarlos")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "Lista con todos los pokemones")
    })
    @GetMapping()
    public ArrayList<PokemonSimpleDto> getAllPokemons(){
        return pokemonService.getAllPokemons();
    }



    @Operation(summary = "Obtener un Pokemón por su nombre", description = "Obtener un pokemón por su nombre con los datos detallados")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "Datos detallados de el pokemón"),
            @ApiResponse(responseCode = "404", description = "Pokemón no encontrado")
    })
    @GetMapping("/detail/{namePokemon:[a-zA-Z-]+}")
    public PokemonViewDetailDto viewDetailPokemonByName(@PathVariable String namePokemon) {
        return pokemonService.viewPokemon(namePokemon);
    }

    @Operation(summary = "Obtener un Pokemón por su ID", description = "Obtener un pokemón por su ID con los datos detallados")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "Datos detallados de el pokemón"),
            @ApiResponse(responseCode = "404", description = "Pokemón no encontrado")
    })
    @GetMapping("/detail/{id:[0-9]+}")
    public PokemonViewDetailDto viewDetailPokemonById(@PathVariable Long id) {
        return pokemonService.pokemonViewDetailDtoById(id);
    }


    @Operation(summary = "Obtener un Pokemón por su Nombre", description = "Obtener un pokemón por su nombre con los datos simples")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "Datos simples de el pokemón"),
            @ApiResponse(responseCode = "404", description = "Pokemón no encontrado")
    })
    @GetMapping("/simple/{namePokemon:[a-zA-Z-]+}")
    public PokemonSimpleDto viewSimplePokemon(@PathVariable String namePokemon) {
        return pokemonService.viewSimplePokemonByName(namePokemon);
    }


    @Operation(summary = "Obtener un Pokemón por su ID", description = "Obtener un pokemón por su ID con los datos simples")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "Datos simples de el pokemón"),
            @ApiResponse(responseCode = "404", description = "Pokemón no encontrado")
    })
    @GetMapping("/simple/{id:[0-9]+}")
    public PokemonSimpleDto viewSimplePokemonById(@PathVariable @Positive Long id) {
        return pokemonService.viewSimplePokemonByid(id);
    }


    @Operation(summary = "Obtener pokemones según el tipo", description = "Obtener una lista de todos los pokemónes que pertenezcan a el tipo ingresado")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "Datos simples de el pokemón")
    })
    @GetMapping("/type/{type}")
    public PokemonByType pokemonByType(@PathVariable String type) {
        return pokemonService.getPokemonByType(type);
    }


}
