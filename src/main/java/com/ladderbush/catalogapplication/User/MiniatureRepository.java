package com.ladderbush.catalogapplication.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MiniatureRepository extends JpaRepository<Miniature, Long> {

    Optional<Miniature> findByMiniatureId(Long id);
}
