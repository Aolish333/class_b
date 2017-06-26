package dao;

import domain.User;
import org.junit.Test;

/**
 * Created by hp on 2017/6/25.
 */
public class UserPackageTest {
    @Test
    public void doLogin() {
        UserPackage userPackage = new UserPackage();
        User user = new User();
        user.setUser_id(1);
        user.setUser_psw("123456");
        userPackage.DoLogin(user);

    }

}