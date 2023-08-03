package com.ladderbush.catalogapplication.User;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Images")
@NoArgsConstructor
public class Image {

    @Id
    @GeneratedValue
    private long imageId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "miniatureId")
    @JsonBackReference
    private Miniature miniature;

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

}
