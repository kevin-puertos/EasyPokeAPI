package io.github.macebot.cobble_api.pokemon.movements;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface IMovementMapper {
    Movement dtoToMovment(MovementDto movementDto);


    MovementDto movToDto(Movement movement);

    List<MovementDto> listToSetMov(Set<Movement> movementSet);


}
