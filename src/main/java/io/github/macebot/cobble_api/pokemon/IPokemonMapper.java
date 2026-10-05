package io.github.macebot.cobble_api.pokemon;

import io.github.macebot.cobble_api.pokemon.ability.IAbilityMapper;
import io.github.macebot.cobble_api.pokemon.dto.PokemonLoadDto;
import io.github.macebot.cobble_api.pokemon.dto.PokemonSimpleDto;
import io.github.macebot.cobble_api.pokemon.dto.PokemonViewDetailDto;
import io.github.macebot.cobble_api.pokemon.movements.IMovementMapper;
import io.github.macebot.cobble_api.pokemon.stats.IStatsMapper;
import io.github.macebot.cobble_api.pokemon.type.ITypeMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {IStatsMapper.class, IAbilityMapper.class, ITypeMapper.class, IMovementMapper.class})
public interface IPokemonMapper {

    Pokemon pokemonLoadToPokemon(PokemonLoadDto pokemonLoadDto);


    PokemonViewDetailDto pokemonToDetailDto(Pokemon pokemon);

    PokemonSimpleDto pokemonToSimpleDto(Pokemon pokemon);


}
