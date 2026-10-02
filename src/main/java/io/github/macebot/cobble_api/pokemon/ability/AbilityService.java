package io.github.macebot.cobble_api.pokemon.ability;
import io.github.macebot.cobble_api.client.service.IPokeApiClient;
import io.github.macebot.cobble_api.exception.exeptions.ResourceNotFound;
import io.github.macebot.cobble_api.pokemon.dto.PokemonViewDto;
import io.github.macebot.cobble_api.pokemon.Pokemon;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tools.jackson.databind.JsonNode;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AbilityService implements IAbilityService {

    private final  IAbilityRepository abilityRepository;
    private final IPokeApiClient pokeApiClient;
    private final IPokemonAbilityRepository pokemonAbilityRepository;

    @Override
    public List<AbilityDto> processAbilities(JsonNode root) {
        JsonNode abilitiesNode =root.get("abilities");

        List<AbilityDto> abilitiesDto = new ArrayList<>();

        if(abilitiesNode.isArray()){
            for(JsonNode item: abilitiesNode){


                String nameAbility = item.get("ability").get("name").asString();
                Boolean isHidden = item.get("is_hidden").asBoolean();
                Integer slot = item.get("slot").asInt();

                JsonNode abilityJson = pokeApiClient.getAbiltyJson(nameAbility);

                JsonNode jsonNode = abilityJson.get("effect_entries");
                String description = "";
                for(JsonNode entrie : jsonNode){
                    if(entrie.get("language").get("name").asString().equals("en")){
                        description = entrie.get("effect").asString();
                    }

                }



                AbilityDto abilityDto = new AbilityDto(nameAbility,isHidden,slot,description);

                abilitiesDto.add(abilityDto);

            }
        }
        return  abilitiesDto;
    }

    @Override
    public void createRelation(PokemonViewDto pokemon, Pokemon pokeToSave) {
        for (AbilityDto ability : pokemon.abilities()){

            if(!abilityRepository.existsById(ability.name())){
                Ability NewAbility = new Ability(ability.name(), ability.description());
                abilityRepository.save(NewAbility);
            }

            Ability aux = abilityRepository.findById(ability.name()).orElseThrow(() -> new ResourceNotFound("Ability Not Found"));

            PokemonAbilityId pokemonAbilityId = new PokemonAbilityId(pokemon.id(),ability.slot(),ability.isHidden(), ability.name());

            PokemonAbility pokemonAbility = new PokemonAbility(pokemonAbilityId,pokeToSave,aux);
            pokeToSave.getAbilities().add(pokemonAbility);

        }
    }
}
