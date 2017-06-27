package dao;

import domain.SalesStatus;
import domain.User;
import org.junit.Test;

import java.util.List;

/**
 * Created by hp on 2017/6/26.
 */
public class TicketSellerPackageTest {
    @Test
    public void selectSalesStatus___Mounth() throws Exception {
        User user = new User();
        user.setUser_id(1);
        TicketSellerPackage ticketSellerPackage = new TicketSellerPackage();
        List<SalesStatus> list = ticketSellerPackage.SelectSalesStatus___Mounth(user);
        for (SalesStatus salesStatus :list){
            System.out.println(salesStatus.toString());
            salesStatus.toString();
        }

    }

    @Test
    public void selectSalesStatus___type(){
        User user = new User();
        user.setUser_id(1);
        TicketSellerPackage ticketSellerPackage = new TicketSellerPackage();
        List<SalesStatus> list = ticketSellerPackage.SelectSalesStatus___type(user);
        for (SalesStatus salesStatus :list){
            System.out.println(salesStatus.toString());
            salesStatus.toString();
        }
    }

    @Test
    public void selectSalesStatus___date() throws Exception {

    }

}