package io.github.macebot.cobble_api.pokemon.movements;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public record MovementDto(
                Long id,
                String name,
                MovementType typeMove,
                String description,
                Long priority,
                Long power,
                Long pp,
                Long acurracy
) {
}
