package io.github.kevin_puertos.EasyPokeAPI.pokemon;

import io.github.kevin_puertos.EasyPokeAPI.pokemon.ability.PokemonAbility;
import io.github.kevin_puertos.EasyPokeAPI.pokemon.movements.Movement;
import io.github.kevin_puertos.EasyPokeAPI.pokemon.stats.Stats;
import io.github.kevin_puertos.EasyPokeAPI.pokemon.type.PokemonTypes;
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
