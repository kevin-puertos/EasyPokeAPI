package io.github.kevin_puertos.EasyPokeAPI.pokemon.stats;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IStatsMapper {
    Stats pokemonStats(StatsDto statsDto);
}
