package io.github.macebot.cobble_api.pokemon.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Movment {
    @Id
    String name;

    String description;

    Long power;

    Long acurracy;

    @ManyToMany(mappedBy = "movments")
    Set<Pokemon> pokemonSet = new HashSet<>();

}
