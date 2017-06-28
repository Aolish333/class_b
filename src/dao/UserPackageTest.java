package dao;

import domain.RefundTicket;
import domain.Ticket;
import domain.User;
import org.junit.Test;

import java.util.List;

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
    @Test
    public void S() {
        UserPackage userPackage = new UserPackage();
        User user = new User();
        user.setUser_id(1);
        List<Ticket> list = userPackage.SelectUserId(user);
//        System.out.println(list);
        for (Ticket ticket : list) {
            System.out.println(ticket.toString());
        }
    }

    @Test
    public void S1() {
        RefundTicket refundTicket = new RefundTicket();
        refundTicket.setUser_id(2);
        refundTicket.setTicket_no(13);
        UserPackage userPackage = new UserPackage();
        int rs = userPackage.RefundBehavior(refundTicket);
        System.out.println(rs);

    }

}