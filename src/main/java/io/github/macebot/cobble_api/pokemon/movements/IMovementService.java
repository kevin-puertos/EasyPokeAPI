package io.github.macebot.cobble_api.pokemon.movements;


import io.github.macebot.cobble_api.pokemon.dto.PokemonViewDto;
import io.github.macebot.cobble_api.pokemon.Pokemon;
import tools.jackson.databind.JsonNode;

import java.util.List;

public interface IMovementService {

    List<MovementDto> processMovements(JsonNode root);
    void createRelation(PokemonViewDto pokemon , Pokemon pokeToSave);

}
