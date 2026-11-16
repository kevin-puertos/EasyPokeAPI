package io.github.kevin_puertos.EasyPokeAPI.pokemon;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IPokemonRepository extends JpaRepository<Pokemon,Long> {
   Optional<Pokemon> findByName(String name);



}
