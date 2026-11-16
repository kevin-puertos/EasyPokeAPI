package io.github.kevin_puertos.EasyPokeAPI.pokemon.movements;


import io.github.kevin_puertos.EasyPokeAPI.pokemon.dto.PokemonLoadDto;
import io.github.kevin_puertos.EasyPokeAPI.pokemon.Pokemon;
import tools.jackson.databind.JsonNode;

import java.util.List;

public interface IMovementService {

    List<MovementDto> processMovements(JsonNode root);
    void createRelation(PokemonLoadDto pokemon , Pokemon pokeToSave);

}
