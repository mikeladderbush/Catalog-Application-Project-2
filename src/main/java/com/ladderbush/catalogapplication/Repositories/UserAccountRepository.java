package com.ladderbush.catalogapplication.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ladderbush.catalogapplication.Entities.UserAccount;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {
    UserAccount findByUsername(String username);
}
