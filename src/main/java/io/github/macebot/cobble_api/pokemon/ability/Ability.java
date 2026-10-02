package io.github.macebot.cobble_api.pokemon.ability;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Ability {
    @Id
    @Column(name= "ability_name")
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

}
