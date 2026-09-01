package io.github.macebot.cobble_api.pokemon.repository;

import io.github.macebot.cobble_api.pokemon.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITypeRepository  extends JpaRepository<Type,Long> {
}
