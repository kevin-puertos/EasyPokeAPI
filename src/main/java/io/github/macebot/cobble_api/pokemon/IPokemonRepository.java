package io.github.macebot.cobble_api.pokemon;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IPokemonRepository extends JpaRepository<Pokemon,Long> {
   Optional<Pokemon> findByName(String name);


}
