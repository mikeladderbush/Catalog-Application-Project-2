package com.ladderbush.catalogapplication.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ladderbush.catalogapplication.Entities.Image;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
    Image findByImageURL(String imageName);
}
