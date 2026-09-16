package io.github.macebot.cobble_api.pokemon.entity;

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

    @OneToMany(mappedBy = "pokemon", fetch = FetchType.EAGER)
    Set<PokemonTypes> pokemonTypesList = new HashSet<>();

    @OneToMany(mappedBy = "pokemon",fetch = FetchType.EAGER)
    Set<PokemonAbility> pokemonAbilities = new HashSet<>() ;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pokemon_id")
    Stats stats ;


    @ManyToMany
    @JoinTable(name = "pokemon_movment",
    joinColumns = @JoinColumn(name = "pokemon_id"),
    inverseJoinColumns = @JoinColumn(name = "movment_id"))
    Set<Movment> movments = new HashSet<>();


}
