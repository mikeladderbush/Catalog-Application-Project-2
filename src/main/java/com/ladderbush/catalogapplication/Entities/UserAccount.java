package com.ladderbush.catalogapplication.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;

@Entity(name = "UserAccount")
@NoArgsConstructor
public class UserAccount {

    @Id
    @GeneratedValue
    private long accountId;

    private String username;

    private String email;

    public UserAccount(long accountId, String username, String email) {
        this.accountId = accountId;
        this.username = username;
        this.email = email;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
