package com.ladderbush.catalogapplication.Controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
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

    @PutMapping("/{token}/{miniatureId}/save")
    public ResponseEntity<Miniature> updateMiniature(
            @PathVariable String token,
            @PathVariable Long miniatureId,
            @RequestBody Miniature updatedMiniature) {

        Optional<Miniature> existingMiniatureOptional = miniatureRepository.findByMiniatureId(miniatureId);

        if (existingMiniatureOptional.isPresent()) {
            Miniature existingMiniature = existingMiniatureOptional.get();

            existingMiniature.setMiniatureName(updatedMiniature.getMiniatureName());
            existingMiniature.setMiniatureScale(updatedMiniature.getMiniatureScale());
            existingMiniature.setMiniatureBrand(updatedMiniature.getMiniatureBrand());

            miniatureRepository.save(existingMiniature);

            HttpHeaders responseHeaders = new HttpHeaders();
            responseHeaders.set("Authorization", "Bearer " + token);

            return new ResponseEntity<>(existingMiniature, responseHeaders, HttpStatus.OK);
        } else {
            updatedMiniature.setMiniatureId(miniatureId);
            miniatureRepository.save(updatedMiniature);

            HttpHeaders responseHeaders = new HttpHeaders();
            responseHeaders.set("Authorization", "Bearer " + token);

            return new ResponseEntity<>(updatedMiniature, responseHeaders, HttpStatus.OK);
        }
    }

    @PostMapping("/{token}/save")
    public ResponseEntity<Miniature> saveMiniature(
            @PathVariable String token,
            @RequestBody Miniature miniature) {

        miniatureRepository.save(miniature);

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Authorization", "Bearer " + token);

        return new ResponseEntity<>(miniature, responseHeaders, HttpStatus.OK);
    }
}
