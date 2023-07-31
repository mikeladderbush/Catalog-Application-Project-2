package com.ladderbush.catalogapplication.Entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

@Entity(name = "Miniature")
@Table(name = "Miniatures")
@NoArgsConstructor
public class Miniature {

    @ManyToOne
    @JoinColumn(name = "username", nullable = false)
    private UserAccount userAccount;

    @Id
    @GeneratedValue
    private long miniatureId;

    private String miniatureName;
    private int scale;
    private String brand;
    private double price;

    public Miniature(long miniatureId, String miniatureName, int scale, String brand, double price) {
        miniatureId = miniatureId;
        this.miniatureName = miniatureName;
        this.scale = scale;
        this.brand = brand;
        this.price = price;
    }

    public long getMiniatureId() {
        return miniatureId;
    }

    public void setMiniatureId(long id) {
        miniatureId = id;
    }

    public String getMiniatureName() {
        return miniatureName;
    }

    public void setMiniatureName(String name) {
        this.miniatureName = name;
    }

    public int getScale() {
        return scale;
    }

    public void setScale(int scale) {
        this.scale = scale;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<Miniature> getImages() {
        return null;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

}
