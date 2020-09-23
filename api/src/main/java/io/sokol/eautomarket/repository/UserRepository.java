package io.sokol.eautomarket.repository;

import io.sokol.eautomarket.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserName(@Param("userName") String userName);
    Optional<User> findByEmail(String email);
}
