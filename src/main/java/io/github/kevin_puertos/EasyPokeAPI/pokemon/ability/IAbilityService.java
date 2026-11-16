package io.github.kevin_puertos.EasyPokeAPI.pokemon.ability;

import io.github.kevin_puertos.EasyPokeAPI.pokemon.dto.PokemonLoadDto;
import io.github.kevin_puertos.EasyPokeAPI.pokemon.Pokemon;
import tools.jackson.databind.JsonNode;

import java.util.List;

public interface IAbilityService {
    List<AbilityDto> processAbilities(JsonNode root);
    void createRelation(PokemonLoadDto pokemon , Pokemon pokeToSave);
}
