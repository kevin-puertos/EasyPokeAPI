package io.github.kevin_puertos.EasyPokeAPI.pokemon;

import io.github.kevin_puertos.EasyPokeAPI.pokemon.ability.IAbilityMapper;
import io.github.kevin_puertos.EasyPokeAPI.pokemon.dto.PokemonLoadDto;
import io.github.kevin_puertos.EasyPokeAPI.pokemon.dto.PokemonSimpleDto;
import io.github.kevin_puertos.EasyPokeAPI.pokemon.dto.PokemonViewDetailDto;
import io.github.kevin_puertos.EasyPokeAPI.pokemon.movements.IMovementMapper;
import io.github.kevin_puertos.EasyPokeAPI.pokemon.stats.IStatsMapper;
import io.github.kevin_puertos.EasyPokeAPI.pokemon.type.ITypeMapper;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring", uses = {IStatsMapper.class, IAbilityMapper.class, ITypeMapper.class, IMovementMapper.class})
public interface IPokemonMapper {

    Pokemon pokemonLoadToPokemon(PokemonLoadDto pokemonLoadDto);

    PokemonViewDetailDto pokemonToDetailDto(Pokemon pokemon);

    PokemonSimpleDto pokemonToSimpleDto(Pokemon pokemon);

    ArrayList<PokemonSimpleDto> pokemonsToListSimple(List<Pokemon> pokemonList);

}
