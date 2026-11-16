package io.github.kevin_puertos.EasyPokeAPI.user.entity;

import io.github.kevin_puertos.EasyPokeAPI.team.entity.Team;
import io.github.kevin_puertos.EasyPokeAPI.user.enums.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Table(name = "user_account")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    String username;
    String password;

    @Enumerated(EnumType.STRING)
    UserRole userRole;

    @OneToMany(mappedBy = "user")
    Set<Team> teams = new HashSet<>();

}
