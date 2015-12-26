package com.pironix;

import com.pironix.document.model.User;
import com.pironix.service.UserService;

/**
 * The Main class
 * <p>
 * Created  on 25.12.2015.
 * <p>
 * Main class save and delete document
 *
 * @version 1.0
 * @user ibrahim KARAYEL
 */
public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();

        User user = new User();
/*        user.setUserId(1);
        user.setUserName("ibrahim");
        user.setFirstName("ibrahim");
        user.setLastName("KARAYEL");
        user.setEmail("ibrahm.karayel@gmal.com");
        userService.saveUser(user);*/

     /*   user = new User();
        user.setUserId(1);
        user.setUserName("ibrahim");
        userService.deleteUser(user);*/

        String[] newKey = {"email", "phone", "enable"};
        user.setUserId(1);
        user.setUserName("ibrahim");
        user.setFirstName("ibrahim");
        user.setLastName("KARAYEL");
        user.setEmail("ibrahm.karayelUpdate@gmal.com");
        user.setPhone("05533807838");
        user.setEnable(true);
        userService.updateUser(user, newKey);

    }
}
