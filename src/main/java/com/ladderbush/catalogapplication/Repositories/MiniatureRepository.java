package com.ladderbush.catalogapplication.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ladderbush.catalogapplication.Entities.Miniature;

@Repository
public interface MiniatureRepository extends JpaRepository<Miniature, Long> {
    Miniature findByMiniatureName(String miniatureName);
}
