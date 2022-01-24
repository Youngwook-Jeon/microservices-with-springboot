package io.young.dev.userservice.repository;

import io.young.dev.userservice.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByUserId(String userId);
}
