package com.ladderbush.catalogapplication.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ladderbush.catalogapplication.Entities.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    UserRole findByRole(String role);
}
