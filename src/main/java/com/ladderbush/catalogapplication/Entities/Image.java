package com.ladderbush.catalogapplication.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

@Entity(name = "Image")
@Table(name = "Images")
@NoArgsConstructor
public class Image {

    @ManyToOne
    @JoinColumn(name="miniatureId", nullable = false)
    private Miniature miniature;

    public Image(long imageId, String imageURL) {
        this.imageId = imageId;
        this.imageURL = imageURL;
    }

    @jakarta.persistence.Id
    @GeneratedValue
    private long imageId;
    private String imageURL;

    public long getImageId() {
        return imageId;
    }

    public void setImageId(long imageId) {
        this.imageId = imageId;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public Miniature getMiniature() {
        return miniature;
    }

    public void setMiniature(Miniature miniature) {
        this.miniature = miniature;
    }
}
