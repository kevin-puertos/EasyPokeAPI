package io.github.macebot.cobble_api.pokemon.ability;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface IAbilityMapper {
    Ability dtoToAblility(AbilityDto abilityDto);

    @Mapping(source = "pokemonAbility.pokemonAbilityId.is_hidden",target = "isHidden")
    @Mapping(source = "pokemonAbility.pokemonAbilityId.slot",target = "slot")
    @Mapping(source = "pokemonAbility.ability.name",target = "name")
    @Mapping(source = "pokemonAbility.ability.description",target = "description")
    AbilityDto fusionToDto(PokemonAbility pokemonAbility);


    List<AbilityDto> setToListDto(Set<PokemonAbility> pokemonAbilities);

}
