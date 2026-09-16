package io.github.macebot.cobble_api.pokemon.mapper;

import io.github.macebot.cobble_api.pokemon.dto.AbilityDto;
import io.github.macebot.cobble_api.pokemon.entity.Ability;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IAbilityMapper {
    Ability dtoToAblility(AbilityDto abilityDto);
}
