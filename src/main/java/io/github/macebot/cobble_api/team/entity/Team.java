package io.github.macebot.cobble_api.team.entity;

import io.github.macebot.cobble_api.pokemon.entity.Pokemon;
import io.github.macebot.cobble_api.user.entity.User;
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
