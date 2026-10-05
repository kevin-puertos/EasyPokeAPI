package io.github.macebot.cobble_api.pokemon;

import io.github.macebot.cobble_api.pokemon.ability.PokemonAbility;
import io.github.macebot.cobble_api.pokemon.movements.Movement;
import io.github.macebot.cobble_api.pokemon.stats.Stats;
import io.github.macebot.cobble_api.pokemon.type.PokemonTypes;
import jakarta.persistence.*;
import lombok.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Pokemon {
    @Id
    @Column(name = "pokemon_id")
    Long id;
    String name;
    String image_url;

    @OneToMany(mappedBy = "pokemon", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    Set<PokemonTypes> types = new HashSet<>();

    @OneToMany(mappedBy = "pokemon",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    Set<PokemonAbility> abilities = new HashSet<>();

    @OneToOne(mappedBy = "pokemon",cascade = CascadeType.ALL)
    Stats stats;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "pokemon_movement",
    joinColumns = @JoinColumn(name = "pokemon_id"),
    inverseJoinColumns = @JoinColumn(name = "movement_id"))
    Set<Movement> movements = new HashSet<>();


}
