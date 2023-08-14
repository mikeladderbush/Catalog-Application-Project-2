
package com.ladderbush.catalogapplication.User;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Miniature {

    private String miniatureName;

    @Id
    @GeneratedValue
    private long miniatureId;

    private String miniatureBrand;
    private String miniatureScale;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "user_id")
    public User user;

    
    @OneToMany(mappedBy = "miniature", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Image> images;
    
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

    public String getMiniatureScale() {
        return miniatureScale;
    }

    public void setMiniatureScale(String miniatureScale) {
        this.miniatureScale = miniatureScale;
    }

}
