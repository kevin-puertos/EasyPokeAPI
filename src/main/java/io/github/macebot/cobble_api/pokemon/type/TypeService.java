package io.github.macebot.cobble_api.pokemon.type;

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
public class TypeService implements ITypeService {

    private final ITypeRepository typeRepository;


    @Override
    public void createRelation(PokemonViewDto pokemon, Pokemon pokeToSave) {
        for(TypeDto type : pokemon.types()){

            //Buscar manera de si ya existe trerlo o si no crearlo
            if(!typeRepository.existsById(type.typeName())){
                Type newtype = new Type();
                newtype.setName(type.typeName());
                newtype.setPokemonTypesList(new ArrayList<PokemonTypes>());

                typeRepository.save(newtype);
            }

            Type aux = typeRepository.findById(type.typeName()).orElseThrow(() -> new ResourceNotFound("Type not found"));

            PokemonTypes pokemonTypes = new PokemonTypes();
            aux.setName(type.typeName());


            pokemonTypes.setPokemon(pokeToSave);
            pokemonTypes.setPokemonTypeId(new PokemonTypeId(pokeToSave.getId(), type.typeName(), type.slot()));
            pokemonTypes.setType(aux);
            aux.getPokemonTypesList().add(pokemonTypes);

            pokeToSave.getTypes().add(pokemonTypes);

        }


    }


    @Override
    public List<TypeDto> processTypes(JsonNode root) {

        //Tipos
        JsonNode types = root.get("types");
        List<TypeDto> typesDto = new ArrayList<>();
        if(types.isArray()){

            for(JsonNode item : types){
                String nametype = item.get("type").get("name").asString();
                Integer slot = item.get("slot").asInt();

                TypeDto type = new TypeDto(slot,nametype);

                typesDto.add(type);
            }
        }
        return  typesDto;
    }




}
