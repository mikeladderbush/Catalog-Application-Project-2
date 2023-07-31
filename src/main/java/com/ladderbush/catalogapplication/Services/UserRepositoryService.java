package com.ladderbush.catalogapplication.Services;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ladderbush.catalogapplication.Entities.Image;
import com.ladderbush.catalogapplication.Entities.Miniature;
import com.ladderbush.catalogapplication.Entities.UserAccount;
import com.ladderbush.catalogapplication.Entities.UserRole;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserRepositoryService {

    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<UserAccount>> getUsers() {
        return ResponseEntity.ok().body(userService.getUserAccounts());
    }

    @GetMapping("/user/miniatures")
    public ResponseEntity<List<Miniature>> getAllMiniatures() {
        return ResponseEntity.ok().body(userService.getMiniatures());
    }

    @GetMapping("/user/miniature/images")
    public ResponseEntity<List<Image>> getAllImages() {
        return ResponseEntity.ok().body(userService.getImages());
    }

    @PostMapping("/user/save")
    public ResponseEntity<Object> saveUserAccount(@RequestBody UserAccount UserAccount) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveUserAccount(UserAccount));
    }

    @PostMapping("/role/save")
    public ResponseEntity<UserRole> saveUserRole(@RequestBody UserRole role) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveUserRole(role));
    }

    @PostMapping("/user/miniature/save")
    public ResponseEntity<Miniature> saveMiniature(@RequestBody Miniature miniature) {
        URI uri = URI.create(
                ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/miniature/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveMiniature(miniature));
    }

    @PostMapping("/user/miniature/image/save")
    public ResponseEntity<Image> saveImage(@RequestBody Image image) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/miniature/image/save")
                .toUriString());
        return ResponseEntity.created(uri).body(userService.saveImage(image));
    }

}