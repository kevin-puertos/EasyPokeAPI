package io.github.kevin_puertos.EasyPokeAPI.pokemon.movements;

import io.github.kevin_puertos.EasyPokeAPI.pokemon.Pokemon;
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
    Long accuracy;

    @ManyToMany(mappedBy = "movements")
    Set<Pokemon> pokemonSet = new HashSet<>();

    public Movement(Long id) {
        this.id = id;
    }
}
