package io.github.macebot.cobble_api.pokemon.mapper;

import io.github.macebot.cobble_api.pokemon.dto.StatsDto;
import io.github.macebot.cobble_api.pokemon.entity.Stats;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IStatsMapper {
    Stats pokemonStats(StatsDto statsDto);
}
