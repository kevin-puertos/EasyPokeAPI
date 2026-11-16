package io.github.kevin_puertos.EasyPokeAPI.pokemon.ability;

public record AbilityDto(
        String name,
        Boolean isHidden,
        Integer slot,
        String description

) {
}
