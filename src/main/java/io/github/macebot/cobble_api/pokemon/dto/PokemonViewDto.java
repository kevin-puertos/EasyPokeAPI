package io.github.macebot.cobble_api.pokemon.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@RequiredArgsConstructor
@Getter @Setter
public class PokemonViewDto {
    private String name;
    private List<String> types;
    private List<String> abilities;




}
