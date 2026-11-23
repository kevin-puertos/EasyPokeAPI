package io.github.kevin_puertos.EasyPokeAPI.pokemon;

import io.github.kevin_puertos.EasyPokeAPI.pokemon.ability.Ability;
import io.github.kevin_puertos.EasyPokeAPI.pokemon.ability.PokemonAbility;
import io.github.kevin_puertos.EasyPokeAPI.pokemon.ability.PokemonAbilityId;
import io.github.kevin_puertos.EasyPokeAPI.pokemon.stats.Stats;
import io.github.kevin_puertos.EasyPokeAPI.pokemon.type.PokemonTypeId;
import io.github.kevin_puertos.EasyPokeAPI.pokemon.type.PokemonTypes;
import io.github.kevin_puertos.EasyPokeAPI.pokemon.type.Type;
import org.jspecify.annotations.NonNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class PokemonServiceTest {

    @Mock
    private IPokemonRepository pokemonRepository;

    @InjectMocks
    private PokemonService pokemonService;


    private Pokemon pokemonTest;

    @BeforeEach
    void setUp() {
        pokemonTest = createFearow();



    }
    //Se crea automáticamente para separar la logica y obtener las habilidades
    private static @NonNull Set<PokemonAbility> abilities(Pokemon pokemonTest) {
        Ability ability1 = new Ability("keen-eye","Whatever");
        Ability ability2 = new Ability("sniper","sniper?");

        Set<PokemonAbility> abilities = new HashSet<>();

        PokemonAbility pokemonAbility1 = new PokemonAbility(new PokemonAbilityId(22L,1,false,"keen-eye"), pokemonTest,ability1);
        PokemonAbility pokemonAbility2 = new PokemonAbility(new PokemonAbilityId(22L,1,false,"sniper"), pokemonTest,ability1);
        abilities.add(pokemonAbility1);
        abilities.add(pokemonAbility2);
        return abilities;
    }

    @Test
    void getPokemonByName_shouldReturnPokemon_whenExists() {

        // Arrange: el repositorio devuelve el Optional con Fearow
        when(pokemonService.pokemonExistByName("fearow")).thenReturn(true);

        // Act : Se ejecuta el método real
        boolean exists = pokemonService.pokemonExistByName("fearow");

        // Assert : Se verifica el resultado e interacción
        assertTrue(exists);
        verify(pokemonRepository).findByName("fearow");
    }

    @Test
    void pokemonExistById() {

        // Arrange: el repositorio devuelve el Optional con Fearow
        when(pokemonService.pokemonExistById(22L)).thenReturn(true);

        // Act : Se ejecuta el método real
        boolean exists = pokemonService.pokemonExistById(22L);

        // Assert : Se verifica el resultado e interacción
        assertTrue(exists);
        verify(pokemonRepository).findById(22L);
    }

    private Pokemon createFearow(){
        //Crear  datos para los tests

        //Pokemon 1°
        Pokemon pokemonTest = new Pokemon();
        pokemonTest.id = 22L;
        pokemonTest.name = "fearow";
        pokemonTest.image_url ="https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/versions/generation-i/red-and-blue/22.png";

        //Types
        Set<PokemonTypes> pokemonTypes = new HashSet<>();

        Type type1 = new Type("normal", List.of());
        Type type2 = new Type("flying", List.of());

        PokemonTypes types1 = new PokemonTypes(new PokemonTypeId(22L,"normal",1),pokemonTest,type1);
        PokemonTypes types2 = new PokemonTypes(new PokemonTypeId(22L,"flying",2),pokemonTest,type2);

        pokemonTypes.add(types1);
        pokemonTypes.add(types2);


        //Abilities
        Set<PokemonAbility> abilities = abilities(pokemonTest);

        //Stats
        Stats stats = new Stats(pokemonTest,65L,90L,65L,61L,61L,100L);

        pokemonTest.setTypes(pokemonTypes);
        pokemonTest.setAbilities(abilities);
        pokemonTest.setStats(stats);
        return  pokemonTest;
    }






}