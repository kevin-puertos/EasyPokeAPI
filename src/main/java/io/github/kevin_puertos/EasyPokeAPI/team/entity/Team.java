package io.github.kevin_puertos.EasyPokeAPI.team.entity;

import io.github.kevin_puertos.EasyPokeAPI.pokemon.Pokemon;
import io.github.kevin_puertos.EasyPokeAPI.user.entity.User;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private  String name;

    @ManyToMany
    @JoinTable(name = "pokemon_team",
    joinColumns = @ JoinColumn(name = "team_id"),
    inverseJoinColumns = @JoinColumn(name = "pokemon_id")
    )
    private Set<Pokemon> pokemonTeam = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "user_account_id")
    private User user;
}
