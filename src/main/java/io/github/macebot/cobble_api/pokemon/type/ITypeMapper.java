package io.github.macebot.cobble_api.pokemon.type;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface ITypeMapper {
    Type dtoToType(TypeDto typeDto);

    @Mapping(source = "pokemonType.pokemonTypeId.slot",target = "slot")
    @Mapping(source = "pokemonType.pokemonTypeId.typeName",target = "typeName")
    TypeDto typeToDto(PokemonTypes pokemonType);

    List<TypeDto> typeSetToDto(Set<PokemonTypes> typeSet);
}
