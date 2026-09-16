package io.github.macebot.cobble_api.pokemon.entity;

import io.github.macebot.cobble_api.pokemon.enums.MovmentType;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Movment {
    @Id
    @Column(name = "movment_id")
    Long id;


    String name;

    @Enumerated(EnumType.STRING)
    MovmentType typeMove;

    String description;

    Long priority;
    Long power;
    Long pp;
    Long acurracy;

    @ManyToMany(mappedBy = "movments")
    Set<Pokemon> pokemonSet = new HashSet<>();

}
