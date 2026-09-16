package io.github.macebot.cobble_api.pokemon.mapper;

import io.github.macebot.cobble_api.pokemon.dto.MovmentDto;
import io.github.macebot.cobble_api.pokemon.entity.Movment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IMovmentMapper {
    Movment dtoToMovment(MovmentDto movmentDto);
}
