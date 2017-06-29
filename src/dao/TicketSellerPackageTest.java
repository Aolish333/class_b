package dao;

import domain.InfoInput;
import domain.SalesStatus;
import domain.User;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by hp on 2017/6/26.
 */
public class TicketSellerPackageTest {
    @Test
    public void insertInfromation() throws Exception {
        InfoInput infoInput = new InfoInput();
        infoInput.setTicket_seller_id(4);
        infoInput.setUser_id(1);
        TicketSellerPackage ticketSellerPackage = new TicketSellerPackage();
        int rs2 = ticketSellerPackage.InsertInfromation(infoInput);
        System.out.println(rs2);
    }


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
        Date date = new Date();

//        beginTime.setTime(begin_time);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = sdf.format(date);
        System.out.println(strDate);
        InfoInput infoInput = new InfoInput();
        infoInput.setUser_id(5);
        infoInput.setSaleDate(strDate);
        TicketSellerPackage ticketSellerPackage = new TicketSellerPackage();

        List<SalesStatus> list = ticketSellerPackage.SelectSalesStatus___date(infoInput);
        for (SalesStatus salesStatus :list){
            System.out.println(salesStatus.toString());
        }

    }

}