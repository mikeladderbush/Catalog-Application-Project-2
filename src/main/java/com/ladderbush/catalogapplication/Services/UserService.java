package com.ladderbush.catalogapplication.Services;

import java.util.List;

import com.ladderbush.catalogapplication.Entities.Image;
import com.ladderbush.catalogapplication.Entities.Miniature;
import com.ladderbush.catalogapplication.Entities.UserAccount;
import com.ladderbush.catalogapplication.Entities.UserRole;

public interface UserService {
    Miniature saveMiniature(Miniature miniature);

    Miniature getMiniature(String miniatureName);

    List<Miniature> getMiniatures();

    Image saveImage(Image image);

    Image getImage(String imageURL);

    List<Image> getImages();

    void addImageToMiniature(String string, String imageURL);

    UserAccount saveUserAccount(UserAccount userAccount);

    UserAccount getUserAccount(String miniatureName);

    List<UserAccount> getUserAccounts();

    void addMiniatureToUserAccount(String username, String miniatureName);

    UserRole saveUserRole(UserRole userRole);

    UserRole getUserRole(String userRole);

    List<UserRole> getUserRoles();

    void addRoleToUserAccount(String username, String role);

}
