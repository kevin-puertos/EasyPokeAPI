package io.github.macebot.cobble_api.pokemon.ability;

public record AbilityDto(
        String name,
        Boolean isHidden,
        Integer slot,
        String description

) {
}
