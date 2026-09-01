package io.github.macebot.cobble_api.pokemon.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Type {
    @Id
    @Column(name = "type_name")
    String name;

    @OneToMany(mappedBy = "type")
    List<PokemonTypes> pokemonTypesList;

}
