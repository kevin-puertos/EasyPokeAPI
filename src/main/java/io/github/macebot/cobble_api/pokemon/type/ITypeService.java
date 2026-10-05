package io.github.macebot.cobble_api.pokemon.type;

import io.github.macebot.cobble_api.pokemon.dto.PokemonLoadDto;
import io.github.macebot.cobble_api.pokemon.Pokemon;
import tools.jackson.databind.JsonNode;

import java.util.List;

public interface ITypeService {
    void createRelation(PokemonLoadDto pokemon, Pokemon pokeToSave);
    List<TypeDto> processTypes(JsonNode root);
}
