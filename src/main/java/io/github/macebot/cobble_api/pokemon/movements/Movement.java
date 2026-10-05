package io.github.macebot.cobble_api.pokemon.movements;

import io.github.macebot.cobble_api.pokemon.Pokemon;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Movement {
    @Id
    @Column(name = "movement_id")
    Long id;
    String name;
    @Enumerated(EnumType.STRING)
    MovementType typeMove;

    @Column(columnDefinition = "text")
    String description;

    Long priority;
    Long power;
    Long pp;
    Long acurracy;

    @ManyToMany(mappedBy = "movements")
    Set<Pokemon> pokemonSet = new HashSet<>();

}
