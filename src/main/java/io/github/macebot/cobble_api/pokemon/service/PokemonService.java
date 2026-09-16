package io.github.macebot.cobble_api.pokemon.service;

import io.github.macebot.cobble_api.client.service.IPokeApiClient;
import io.github.macebot.cobble_api.exception.exeptions.ResourceNotFound;
import io.github.macebot.cobble_api.pokemon.dto.*;
import io.github.macebot.cobble_api.pokemon.entity.Movment;
import io.github.macebot.cobble_api.pokemon.entity.Pokemon;
import io.github.macebot.cobble_api.pokemon.enums.MovmentType;
import io.github.macebot.cobble_api.pokemon.mapper.IPokemonMapper;
import io.github.macebot.cobble_api.pokemon.repository.IPokemonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class PokemonService implements IPokemonService{

    private final ObjectMapper objectMapper;
    private final IPokemonMapper pokemonMapper;
    private final IPokeApiClient pokeApiClient;
    private final IPokemonRepository pokemonRepository;

    @Override
    public PokemonViewDto viewPokemon(String pokemonName) {
        return this.processJson(pokemonName);
    }


    @Override
    public List<AbilityDto> processAbilities(JsonNode root) {
        JsonNode abilitiesNode =root.get("abilities");

        List<AbilityDto> abilitiesDto = new ArrayList<>();

        if(abilitiesNode.isArray()){
            for(JsonNode item: abilitiesNode){


                String nameAbility = item.get("ability").get("name").asText();
                Boolean isHiden = item.get("is_hidden").asBoolean();

                AbilityDto abilityDto = new AbilityDto(nameAbility,isHiden);

                abilitiesDto.add(abilityDto);

            }
        }
        return  abilitiesDto;
    }

    @Override
    public StatsDto processStats(JsonNode root) {
        //Estadisticas

        JsonNode stats = root.get("stats");

        StatsDto statsDto = new StatsDto();

            for(JsonNode item: stats){

                String statName = item.get("stat").get("name").asString();

                switch (statName){
                    case "hp":
                        statsDto.setHp(item.get("base_stat").asLong());
                        break;
                    case "attack":
                        statsDto.setAtk(item.get("base_stat").asLong());
                        break;
                    case "defense":
                        statsDto.setDef(item.get("base_stat").asLong());
                        break;
                    case "special-attack":
                        statsDto.setAtaEsp(item.get("base_stat").asLong());
                        break;

                    case "special-defense":
                        statsDto.setDefEsp(item.get("base_stat").asLong());
                        break;

                    case "speed":
                        statsDto.setSpe(item.get("base_stat").asLong());
                        break;
                    default:
                        break;
                }
            }
            return  statsDto;
    }

    @Override
    public List<TypeDto> processTypes(JsonNode root) {

        //Tipos
        JsonNode types = root.get("types");
        List<TypeDto> typesDto = new ArrayList<>();
        if(types.isArray()){

            for(JsonNode item : types){
                String nametype = item.get("type").get("name").asString();
                Long slot = item.get("slot").asLong();

                TypeDto type = new TypeDto(slot,nametype);

                typesDto.add(type);
            }
        }
        return  typesDto;
    }


    @Override
    public PokemonByType getPokemonByType(String type) {
        String json = pokeApiClient.getTypeJson(type);

        JsonNode root = objectMapper.readTree(json);


        List <PokemonWithTypeDto> pokemonWithtype = new ArrayList<>();

        String name = root.get("name").asString();

        JsonNode pokemon = root.get("pokemon");

        if(pokemon.isArray()){

            for(JsonNode item : pokemon){
                Long slot = item.get("slot").asLong();
                String pokemonName = item.get("pokemon").get("name").asString();

                PokemonWithTypeDto aux = new PokemonWithTypeDto(slot,pokemonName);

                pokemonWithtype.add(aux);

            }
        }
        return  new PokemonByType(name,pokemonWithtype);
    }

    @Override
    public List<MovmentDto> processMovments(JsonNode root) {
        List<MovmentDto> movmentDtoList = new ArrayList<>();
        JsonNode moves = root.get("moves");
        if(moves.isArray()){


            for(JsonNode item : moves){

                String name = item.get("move").get("name").asString();
                JsonNode moveJson = pokeApiClient.getMoveJson(name);

                Long id = moveJson.get("id").asLong();
                Long accuracy = moveJson.get("accuracy").asLong();
                Long pp = moveJson.get("pp").asLong();
                Long power = moveJson.get("power").asLong();
                Long priority = moveJson.get("priority").asLong();
                MovmentType movmentType = MovmentType.valueOf(moveJson.get("damage_class").get("name").asString().toUpperCase());
                JsonNode jsonNode = moveJson.get("effect_entries");
                String description = " ";
                for(JsonNode entrie :jsonNode){
                    if(entrie.get("language").get("name").asString() == "en"){

                        description = entrie.get("short_effect").asString();


                    }
                }

                MovmentDto mov = new MovmentDto(id,name,movmentType,description,priority,power,pp,accuracy);
                movmentDtoList.add(mov);



            }
        }
        return movmentDtoList;
    }

    @Override
    public PokemonViewDto processJson(String pokemonName) {
        String json = pokeApiClient.getPokemonJson(pokemonName);

        //Convertir de String a JsonNode
        JsonNode root = objectMapper.readTree(json);

        String name = root.get("name").asString();
        Long id = root.get("id").asLong();

        List<AbilityDto> abilitiesDtos =processAbilities(root);
        StatsDto statDtos = processStats(root);
        List<TypeDto> typesDto = processTypes(root);
        List<MovmentDto> movmentDtos = this.processMovments(root);


       PokemonViewDto pokemonViewDto = new PokemonViewDto(id,name,typesDto,abilitiesDtos,statDtos,movmentDtos);

       this.loadPokemon(pokemonViewDto);

       return  pokemonViewDto;
    }



    @Override
    public void loadPokemon(PokemonViewDto pokemon) {
        pokemonRepository.save( pokemonMapper.pokemonViewToPokemon(pokemon));

    }
}
