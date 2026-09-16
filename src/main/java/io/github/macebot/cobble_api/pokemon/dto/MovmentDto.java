package io.github.macebot.cobble_api.pokemon.dto;

import io.github.macebot.cobble_api.pokemon.enums.MovmentType;
import jakarta.persistence.Id;

public record MovmentDto(
                Long id,
                String name,

                MovmentType typeMove,

                String description,

                Long priority,
                Long power,
                Long pp,
                Long acurracy

) {
}
