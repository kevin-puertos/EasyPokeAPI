package io.github.macebot.cobble_api.pokemon.ability;

import io.github.macebot.cobble_api.pokemon.dto.PokemonViewDto;
import io.github.macebot.cobble_api.pokemon.Pokemon;
import tools.jackson.databind.JsonNode;

import java.util.List;

public interface IAbilityService {
    List<AbilityDto> processAbilities(JsonNode root);
    void createRelation(PokemonViewDto pokemon , Pokemon pokeToSave);
}
