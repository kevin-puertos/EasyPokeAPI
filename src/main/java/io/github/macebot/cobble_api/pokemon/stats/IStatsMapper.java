package io.github.macebot.cobble_api.pokemon.stats;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IStatsMapper {
    Stats pokemonStats(StatsDto statsDto);
}
