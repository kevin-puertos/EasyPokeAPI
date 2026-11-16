package io.github.kevin_puertos.EasyPokeAPI.user.repository;

import io.github.kevin_puertos.EasyPokeAPI.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User,Long> {
}
