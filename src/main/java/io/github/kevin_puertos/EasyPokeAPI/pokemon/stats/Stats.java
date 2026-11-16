package io.github.kevin_puertos.EasyPokeAPI.pokemon.stats;

import io.github.kevin_puertos.EasyPokeAPI.pokemon.Pokemon;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Stats {
    @Id
    @OneToOne(fetch = FetchType.LAZY)
     @JoinColumn(name ="pokemon_id")
    Pokemon pokemon = new Pokemon();
    private Long hp;
    private Long atk;
    private Long def;
    private Long ataEsp;
    private Long defEsp;
    private Long spe;




}
