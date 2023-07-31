package com.ladderbush.catalogapplication.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ladderbush.catalogapplication.Entities.Image;
import com.ladderbush.catalogapplication.Entities.Miniature;
import com.ladderbush.catalogapplication.Entities.UserAccount;
import com.ladderbush.catalogapplication.Entities.UserRole;
import com.ladderbush.catalogapplication.Repositories.ImageRepository;
import com.ladderbush.catalogapplication.Repositories.MiniatureRepository;
import com.ladderbush.catalogapplication.Repositories.UserAccountRepository;
import com.ladderbush.catalogapplication.Repositories.UserRoleRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImplementation implements UserService {

    private final MiniatureRepository miniatureRepository;
    private final ImageRepository imageRepository;
    private final UserAccountRepository userAccountRepository;
    private final UserRoleRepository userRoleRepository;

    @Override
    public Miniature saveMiniature(Miniature miniature) {
        return miniatureRepository.save(miniature);
    }

    @Override
    public Image saveImage(Image image) {
        return imageRepository.save(image);
    }

    @Override
    public Miniature getMiniature(String miniatureName) {
        return miniatureRepository.findByMiniatureName(miniatureName);
    }

    @Override
    public List<Miniature> getMiniatures() {
        return miniatureRepository.findAll();
    }

    @Override
    public Image getImage(String imageUrl) {
        return imageRepository.findByImageURL(imageUrl);
    }

    @Override
    public List<Image> getImages() {
        return imageRepository.findAll();
    }

    @Override
    public UserAccount saveUserAccount(UserAccount userAccount) {
        return userAccountRepository.save(userAccount);
    }

    @Override
    public UserAccount getUserAccount(String username) {
        return userAccountRepository.findByUsername(username);
    }

    @Override
    public List<UserAccount> getUserAccounts() {
        return userAccountRepository.findAll();
    }

    @Override
    public UserRole saveUserRole(UserRole userRole) {
        return userRoleRepository.save(userRole);
    }

    @Override
    public UserRole getUserRole(String userRole) {
        return userRoleRepository.findByRole(userRole);
    }

    @Override
    public List<UserRole> getUserRoles() {
        return userRoleRepository.findAll();
    }

    @Override
    public void addImageToMiniature(String string, String imageURL) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addImageToMiniature'");
    }

    @Override
    public void addMiniatureToUserAccount(String username, String miniatureName) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addMiniatureToUserAccount'");
    }

    @Override
    public void addRoleToUserAccount(String username, String role) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addRoleToUserAccount'");
    }

}