package com.ladderbush.catalogapplication.User;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Miniatures")
@NoArgsConstructor
public class Miniature {

    private String miniatureName;

    @Id
    @GeneratedValue
    private long miniatureId;

    private String miniatureBrand;
    private int scale;

    @OneToMany(mappedBy = "miniature", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Image> images = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    @JsonBackReference
    private User user;

    public String getMiniatureName() {
        return miniatureName;
    }


    public void setMiniatureName(String miniatureName) {
        this.miniatureName = miniatureName;
    }

    public long getMiniatureId() {
        return miniatureId;
    }

    public void setMiniatureId(long id) {
        miniatureId = id;
    }

    public String getMiniatureBrand() {
        return miniatureBrand;
    }

    public void setMiniatureBrand(String miniatureBrand) {
        this.miniatureBrand = miniatureBrand;
    }

    public int getScale() {
        return scale;
    }

    public void setScale(int scale) {
        this.scale = scale;
    }

    // implement list of attributes eventually

}
