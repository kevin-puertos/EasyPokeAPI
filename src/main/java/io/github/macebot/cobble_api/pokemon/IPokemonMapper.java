package io.github.macebot.cobble_api.pokemon;

import io.github.macebot.cobble_api.pokemon.ability.IAbilityMapper;
import io.github.macebot.cobble_api.pokemon.dto.PokemonViewDto;
import io.github.macebot.cobble_api.pokemon.movements.IMovementMapper;
import io.github.macebot.cobble_api.pokemon.stats.IStatsMapper;
import io.github.macebot.cobble_api.pokemon.type.ITypeMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {IStatsMapper.class, IAbilityMapper.class, ITypeMapper.class, IMovementMapper.class})
public interface IPokemonMapper {

    Pokemon pokemonViewToPokemon(PokemonViewDto pokemonViewDto);


    PokemonViewDto pokemonToDto(Pokemon pokemon);



}
