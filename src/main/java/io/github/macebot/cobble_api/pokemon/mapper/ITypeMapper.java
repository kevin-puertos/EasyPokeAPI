package io.github.macebot.cobble_api.pokemon.mapper;

import io.github.macebot.cobble_api.pokemon.dto.TypeDto;
import io.github.macebot.cobble_api.pokemon.entity.Type;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ITypeMapper {
    Type dtoToType(TypeDto typeDto);
}
