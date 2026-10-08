package io.github.macebot.cobble_api.pokemon.movements;

import io.github.macebot.cobble_api.client.service.PokeApiClient;
import io.github.macebot.cobble_api.exception.exeptions.ResourceNotFound;
import io.github.macebot.cobble_api.pokemon.dto.PokemonLoadDto;
import io.github.macebot.cobble_api.pokemon.Pokemon;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tools.jackson.databind.JsonNode;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MovementService implements  IMovementService{

    private  final PokeApiClient pokeApiClient;
    private  final IMovementMapper movementMapper;
    private  final IMovementRepository movementRepository;

    @Override
    public List<MovementDto> processMovements(JsonNode root) {
        List<MovementDto> movementDtoList = new ArrayList<>();
        JsonNode moves = root.get("moves");
        if(moves.isArray()){


            for(JsonNode item : moves){

                //Obtengo el id del movimiento desde la url
                String url = item.get("move").get("url").asString();
                String[] partes = url.split("/");
                Long idNum = Long.parseLong(partes[partes.length-1]);



              /*
              * Estoy haciendo consultas a la api sin ver si ya tengo los movimientos en la base de datos
              * */
                if(!movementRepository.existsById(idNum)) {

                    String name = item.get("move").get("name").asString();
                    JsonNode moveJson = pokeApiClient.getMoveJson(name);

                    Long id = moveJson.get("id").asLong();
                    Long accuracy = moveJson.get("accuracy").asLong();
                    Long pp = moveJson.get("pp").asLong();
                    Long power = moveJson.get("power").asLong();
                    Long priority = moveJson.get("priority").asLong();
                    MovementType movementType = MovementType.valueOf(moveJson.get("damage_class").get("name").asString().toUpperCase());
                    JsonNode jsonNode = moveJson.get("effect_entries");
                    String description = " ";
                    for (JsonNode entrie : jsonNode) {
                        if (entrie.get("language").get("name").asString().equals("en")) {

                            description = entrie.get("short_effect").asString();


                        }
                    }
                    MovementDto mov = new MovementDto(id, name, movementType, description, priority, power, pp, accuracy);
                    movementDtoList.add(mov);

                }


                MovementDto mov = new MovementDto(idNum);
                movementDtoList.add(mov);

            }
        }
        return movementDtoList;
    }


    @Override
    public void createRelation(PokemonLoadDto pokemon, Pokemon pokeToSave) {
        for(MovementDto movement : pokemon.movements()){

            if(!movementRepository.existsById(movement.getId())){
               Movement aux = movementRepository.save(movementMapper.dtoToMovment(movement));
                aux.getPokemonSet().add(pokeToSave);
            }
            Movement aux = movementRepository.findById(movement.getId()).orElseThrow(() -> new ResourceNotFound("Movement not found"));
           aux.getPokemonSet().add(pokeToSave);
           pokeToSave.getMovements().add(aux);
        }

    }
}
