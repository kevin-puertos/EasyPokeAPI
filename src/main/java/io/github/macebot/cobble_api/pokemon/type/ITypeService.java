package io.github.macebot.cobble_api.pokemon.type;

import io.github.macebot.cobble_api.pokemon.dto.PokemonViewDto;
import io.github.macebot.cobble_api.pokemon.Pokemon;
import tools.jackson.databind.JsonNode;

import java.util.List;

public interface ITypeService {
    void createRelation(PokemonViewDto pokemon, Pokemon pokeToSave);
    List<TypeDto> processTypes(JsonNode root);
}
