package com.ladderbush.catalogapplication.Controller;

import io.swagger.v3.oas.annotations.Hidden;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ladderbush.catalogapplication.User.Miniature;
import com.ladderbush.catalogapplication.User.MiniatureRepository;

@RestController
@RequestMapping("/api/v1/miniature-controller")
@Hidden
public class MiniatureController {

    private MiniatureRepository miniatureRepository;

    @GetMapping
    public Optional<Miniature> getMiniature(Long miniatureId){
        return miniatureRepository.findByMiniatureId(miniatureId);
    }

}