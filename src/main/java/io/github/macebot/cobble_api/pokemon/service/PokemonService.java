package io.github.macebot.cobble_api.pokemon.service;

import io.github.macebot.cobble_api.exception.exeptions.ResourceNotFound;
import io.github.macebot.cobble_api.pokemon.dto.*;
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
    private final RestClient restClient;

    @Override
    public PokemonViewDto viewPokemon(String pokemonName) {
        return this.processJson(pokemonName);
    }


    @Override
    public List<AbilityDto> processAbilities(JsonNode root,String json) {
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
    public List<StatDto> processStats(JsonNode root,String json) {
        //Estadisticas

        JsonNode stats = root.get("stats");

        List<StatDto> statDtos = new ArrayList<>();

        if(stats.isArray()){

            for(JsonNode item: stats){

                String statName = item.get("stat").get("name").asString();
                Long statValue = item.get("base_stat").asLong();
                StatDto statDto = new StatDto(statName,statValue);
                statDtos.add(statDto);

            }



        }
        return  statDtos;
    }

    @Override
    public List<TypeDto> processTypes(JsonNode root,String json) {

        //Tipos
        JsonNode types = root.get("types");
        List<TypeDto> typesDto = new ArrayList<>();
        if(types.isArray()){

            for(JsonNode item : types){
                String nametype = item.get("type").get("name").asText();
                Long slot = item.get("slot").asLong();

                TypeDto type = new TypeDto(slot,nametype);

                typesDto.add(type);
            }
        }
        return  typesDto;
    }

    @Override
    public String getPokemonJson(String pokemonName) {
        return  restClient
                .get()
                .uri("/pokemon/{pokemonName}",pokemonName)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError,
                        ((request, response) ->
                        {throw new ResourceNotFound("Pokemon not found");}))
                .body(String.class);

    }

    @Override
    public PokemonViewDto processJson(String pokemonName) {
        String json = this.getPokemonJson(pokemonName);

        //Convertir de String a JsonNode
        JsonNode root = objectMapper.readTree(json);

        String name = root.get("name").asText();
        Long id = root.get("id").asLong();

        List<AbilityDto> abilitiesDtos =processAbilities(root,json);
        List<StatDto> statDtos = processStats(root,json);
        List<TypeDto> typesDto = processTypes(root,json);

        return new PokemonViewDto(id,name,typesDto,abilitiesDtos,statDtos);
    }


    @Override
    public String getTypeJson(String type) {
        return  restClient
                .get()
                .uri("/type/{type}",type)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError,
                        ((request, response) ->
                        {throw new ResourceNotFound("Type not found");}))
                .body(String.class);

    }

    @Override
    public PokemonByType getPokemonByType(String type) {
        String json = getTypeJson(type);

        JsonNode root = objectMapper.readTree(json);


        List <PokemonWithTypeDto> pokemonWithtype = new ArrayList<>();

        String name = root.get("name").asText();

        JsonNode pokemon = root.get("pokemon");

        if(pokemon.isArray()){

            for(JsonNode item : pokemon){
                Long slot = item.get("slot").asLong();
                String pokemonName = item.get("pokemon").get("name").asText();

                PokemonWithTypeDto aux = new PokemonWithTypeDto(slot,pokemonName);

                pokemonWithtype.add(aux);

            }
        }
        PokemonByType pokemonByType = new PokemonByType(name,pokemonWithtype);

        return pokemonByType;
    }
}
