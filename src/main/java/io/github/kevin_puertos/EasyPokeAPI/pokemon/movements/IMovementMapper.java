package io.github.kevin_puertos.EasyPokeAPI.pokemon.movements;

import org.mapstruct.Mapper;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface IMovementMapper {
    Movement dtoToMovment(MovementDto movementDto);


    MovementDto movToDto(Movement movement);

    List<MovementDto> listToSetMov(Set<Movement> movementSet);


}
