package com.ladderbush.catalogapplication.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ladderbush.catalogapplication.Entities.EnumRole;
import com.ladderbush.catalogapplication.Entities.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    Optional<UserRole> findByName(EnumRole name);
}
