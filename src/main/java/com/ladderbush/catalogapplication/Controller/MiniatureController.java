package com.ladderbush.catalogapplication.Controller;

import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.ladderbush.catalogapplication.User.Miniature;
import com.ladderbush.catalogapplication.User.MiniatureRepository;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/miniature-controller")
@Hidden
public class MiniatureController {

    @Autowired
    private MiniatureRepository miniatureRepository;

    @GetMapping
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("Hello from secured endpoint");
    }

    @GetMapping("/{token}/{miniatureId}")
    public ResponseEntity<Miniature> getMiniature(@PathVariable Long miniatureId) {
        Optional<Miniature> miniatureOptional = miniatureRepository.findByMiniatureId(miniatureId);
        if (miniatureOptional.isPresent()) {
            return ResponseEntity.ok(miniatureOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{token}")
    public ResponseEntity<List<Miniature>> getAllMiniatures() {
        List<Miniature> miniatures = miniatureRepository.findAll();
        return ResponseEntity.ok(miniatures);
    }
}
