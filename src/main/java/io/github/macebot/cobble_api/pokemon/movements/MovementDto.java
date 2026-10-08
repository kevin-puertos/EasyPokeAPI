package io.github.macebot.cobble_api.pokemon.movements;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public  class MovementDto {

    Long id;
    String name;
    MovementType typeMove;
    String description;
    Long priority;
    Long power;
    Long pp;
    Long acurracy;

    public MovementDto(Long id) {
        this.id = id;
    }
}
