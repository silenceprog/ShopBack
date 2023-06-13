package org.example.repos;

import org.example.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepos extends JpaRepository<UserEntity,Long> {
}
