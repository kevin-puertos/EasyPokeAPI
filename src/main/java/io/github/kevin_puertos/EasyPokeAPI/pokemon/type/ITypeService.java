package io.github.kevin_puertos.EasyPokeAPI.pokemon.type;

import io.github.kevin_puertos.EasyPokeAPI.pokemon.dto.PokemonLoadDto;
import io.github.kevin_puertos.EasyPokeAPI.pokemon.Pokemon;
import tools.jackson.databind.JsonNode;

import java.util.List;

public interface ITypeService {
    void createRelation(PokemonLoadDto pokemon, Pokemon pokeToSave);
    List<TypeDto> processTypes(JsonNode root);
}
