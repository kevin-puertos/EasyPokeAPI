package io.github.macebot.cobble_api.pokemon.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Stats {
    @Id
    @OneToOne
    @JoinColumn(name="pokemon_id")
    Pokemon pokemon;
    private Long hp;
    private Long atk;
    private Long def;
    private Long ataEsp;
    private Long defEsp;
    private Long spe;




}
