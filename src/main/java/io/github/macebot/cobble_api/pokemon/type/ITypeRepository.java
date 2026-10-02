package io.github.macebot.cobble_api.pokemon.type;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITypeRepository  extends JpaRepository<Type,String> {
}
