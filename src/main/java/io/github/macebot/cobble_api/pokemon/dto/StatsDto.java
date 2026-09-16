package io.github.macebot.cobble_api.pokemon.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class StatsDto {
    private Long hp;
    private Long atk;
    private Long def;
    private Long ataEsp;
    private Long defEsp;
    private Long spe;
}
