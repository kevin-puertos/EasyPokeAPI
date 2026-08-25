package io.github.macebot.cobble_api.user.entity;

import io.github.macebot.cobble_api.user.enums.UserRole;
import jakarta.persistence.*;

public record User(
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        Long id,
        String username,
        String password,
        @Enumerated(EnumType.STRING)
        UserRole userRole

) {
}
