package io.github.macebot.cobble_api.pokemon;

import io.github.macebot.cobble_api.client.service.IPokeApiClient;
import io.github.macebot.cobble_api.exception.exeptions.ResourceNotFound;
import io.github.macebot.cobble_api.pokemon.ability.AbilityDto;
import io.github.macebot.cobble_api.pokemon.ability.IAbilityService;
import io.github.macebot.cobble_api.pokemon.dto.*;
import io.github.macebot.cobble_api.pokemon.movements.IMovementService;
import io.github.macebot.cobble_api.pokemon.movements.MovementDto;
import io.github.macebot.cobble_api.pokemon.stats.IStatsMapper;
import io.github.macebot.cobble_api.pokemon.stats.StatsDto;
import io.github.macebot.cobble_api.pokemon.type.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
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

        private final IAbilityService abilityService;
        private final ITypeService typeService;
        private final IMovementService movementService;

        private final IStatsMapper statsMapper;

        @Override
        public PokemonViewDto viewPokemon(String pokemonName) {
            return this.processJson(pokemonName);
        }

        @Override
        public Pokemon getPokemon(Long id) {
            return pokemonRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Pokemon not found"));
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
        public void loadPokemon(PokemonViewDto pokemon) {

            // Contruir las relaciones porque el mapper no lo hace
            //Eliminar que haga las relaciones porque queda una siempre en null
            Pokemon pokeToSave = new Pokemon();
            pokeToSave.setId(pokemon.id());
            pokeToSave.setName(pokemon.name());
            pokeToSave.setImage_url(pokemon.image_url());
            typeService.createRelation(pokemon,pokeToSave);
            movementService.createRelation(pokemon,pokeToSave);
            abilityService.createRelation(pokemon,pokeToSave);

            pokeToSave.setStats( statsMapper.pokemonStats(pokemon.stats()));
            pokeToSave.getStats().setPokemon(pokeToSave);
            pokemonRepository.save(pokeToSave);

        }

        @Transactional
        @Override
        public PokemonViewDto processJson(String pokemonName) {
            String json = pokeApiClient.getPokemonJson(pokemonName);



            JsonNode root = objectMapper.readTree(json);
            Long id = root.get("id").asLong();
            if(! pokemonRepository.existsById(id)){
                String name = root.get("name").asString();


                List<AbilityDto> abilitiesDtos = abilityService.processAbilities(root);
                StatsDto statDtos = processStats(root);
                String imageUrl = root.get("sprites").get("other").get("official-artwork").get("front_default").asString();
                List<TypeDto> typesDto = typeService.processTypes(root);
                List<MovementDto> movementDtos = movementService.processMovements(root);

                PokemonViewDto pokeview = new PokemonViewDto(id,name,imageUrl,typesDto,abilitiesDtos,statDtos, movementDtos);

                this.loadPokemon(pokeview);
                return pokeview;

            }

            Pokemon pok = this.getPokemon(id);

           return  pokemonMapper.pokemonToDto(pok);
        }




}
