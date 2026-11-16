package io.github.kevin_puertos.EasyPokeAPI.pokemon.type;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITypeRepository  extends JpaRepository<Type,String> {
}
