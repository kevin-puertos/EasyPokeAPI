package io.github.macebot.cobble_api.pokemon.mapper;

import io.github.macebot.cobble_api.pokemon.dto.PokemonViewDto;
import io.github.macebot.cobble_api.pokemon.entity.Pokemon;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {IStatsMapper.class, IAbilityMapper.class, ITypeMapper.class, IMovmentMapper.class})
public interface IPokemonMapper {
    Pokemon pokemonViewToPokemon(PokemonViewDto pokemonViewDto);



}
