package com.ladderbush.catalogapplication.User;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MiniatureRepository extends JpaRepository<Miniature, Long> {

    Optional<Miniature> findByMiniatureId(Long id);

}
