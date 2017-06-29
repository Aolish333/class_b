package dao;

import domain.InfoInput;
import domain.SalesStatus;
import domain.TicketSeller;
import domain.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hp on 2017/6/26.
 */
public class TicketSellerPackage extends CloseDao {
    /**
     * 记录销售情况
     */
    public int InsertInfromation(InfoInput infoInput) {
        int rs = 0;
        PreparedStatement ps = null;
        Connection connection = null;
        String sql_insert = "INSERT INTO  info_input VALUES(?,(SELECT max(ticket_no) FROM ticket ORDER BY ticket.ticket_no),?,CURDATE());";
        try {
            Conn conn = new Conn();
            connection = conn.getConn();
            //Statement接口提供了查询语句和获取查询结果的基本方法
            ps = connection.prepareStatement(sql_insert);
            ps.setInt(1,infoInput.getTicket_no());
            ps.setInt(2,infoInput.getUser_id());
            rs = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            CloseAll(connection, null, ps);
        }
        return rs;
    }

    /**
     * 获取月份的销售情况
     */
    public List<SalesStatus> SelectSalesStatus___Mounth(User user) {
        Conn conn = new Conn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection connection = null;
        List<SalesStatus> list = new ArrayList<SalesStatus>();
        SalesStatus salesStatus = null;
        String sql_select = "SELECT month(SaleDate)月份,sum(ticket.ticket_price)销售金额,count(ticket.ticket_no)销售情况\n" +
                "FROM INFO_INPUT,ticket LEFT JOIN refund_ticket ON ticket.ticket_no = refund_ticket.ticket_no\n" +
                "WHERE ticket.ticket_no NOT IN (SELECT ticket_no FROM refund_ticket) AND INFO_INPUT.ticket_no = ticket.ticket_no GROUP BY  month(INFO_INPUT.SaleDate) AND ticket.ticket_no = ?;";
        try {
            connection = conn.getConn();
            ps = connection.prepareStatement(sql_select);
            ps.setInt(1, user.getUser_id());
            rs = ps.executeQuery();
            while (rs.next()) {
                salesStatus= new SalesStatus();
                salesStatus.setMonthly(rs.getInt(1));
                salesStatus.setSales_earning(rs.getInt(2));
                salesStatus.setSales_amount(rs.getInt(3));
                list.add(salesStatus);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            CloseAll(connection, rs, ps);
        }
        return list;
    }


    /**
     * 查询各门票销售类型的销售情况
     */
    public List<SalesStatus> SelectSalesStatus___type(User user) {
        Conn conn = new Conn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection connection = null;
        List<SalesStatus> list = new ArrayList<SalesStatus>();
        SalesStatus salesStatus = new SalesStatus();
        String sql_select = "SELECT ticket.ticket_type ,ticket.ticket_price, sum(ticket.ticket_price)总收入,count(ticket.ticket_no)销售量\n" +
                "FROM ticket,INFO_INPUT WHERE ticket_seller_id =? AND INFO_INPUT.ticket_no = ticket.ticket_no AND ticket.ticket_no NOT IN (SELECT ticket_no FROM refund_ticket) GROUP BY ticket_type;";
        try {
            connection = conn.getConn();
            ps = connection.prepareStatement(sql_select);
            ps.setString(1, String.valueOf(user.getUser_id()));
            rs = ps.executeQuery();
            while (rs.next()) {
                salesStatus = new SalesStatus();
                salesStatus.setSales_type(rs.getString(1));
                salesStatus.setSales_price(rs.getInt(2));
                salesStatus.setSales_earning(rs.getInt(3));
                salesStatus.setSales_amount(rs.getInt(4));
                list.add(salesStatus);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            CloseAll(connection, rs, ps);
        }
        return list;
    }

    /**
     * 指定日期的销售情况
     */
    public List<SalesStatus> SelectSalesStatus___date(InfoInput infoInput) {
        Conn conn = new Conn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection connection = null;
        List<SalesStatus> list = new ArrayList<SalesStatus>();
        SalesStatus salesStatus = null;
        int Ticket_seller_id = infoInput.getTicket_seller_id();
        Date data = Date.valueOf(infoInput.getSaleDate());

        String sql_select = "SELECT ticket.ticket_type ,ticket.ticket_price, sum(ticket.ticket_price)总收入,count(ticket.ticket_no)销售量 FROM ticket, INFO_INPUT WHERE INFO_INPUT.ticket_no = ticket.ticket_no AND SaleDate= '"+data+"' AND ticket.ticket_no NOT IN (SELECT ticket_no FROM refund_ticket) GROUP BY ticket_type AND ticket_seller_id = '"+Ticket_seller_id+"';";
        try {
            connection = conn.getConn();
            ps = connection.prepareStatement(sql_select);
//            ps.setInt(1, infoInput.getTicket_seller_id());
//            ps.setDate(1, Date.valueOf(infoInput.getSaleDate()));
            rs = ps.executeQuery();
            while (rs.next()) {
                salesStatus = new SalesStatus();
                salesStatus.setSales_type(rs.getString(1));
                salesStatus.setSales_price(rs.getInt(2));
                salesStatus.setSales_earning(rs.getInt(3));
                salesStatus.setSales_amount(rs.getInt(4));
                list.add(salesStatus);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            CloseAll(connection, rs, ps);
        }
        return list;
    }


    /**
     * 用户登陆
     *
     * @param ticketSeller
     * @return
     */
    public ResultSet DoLogin(TicketSeller ticketSeller) {
        String sql_select = "SELECT * FROM ticket_seller WHERE ticket_seller.ticket_seller_id = ? AND ticket_seller_psw = ?;";
        Conn conn = new Conn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection connection = null;
        try {
            connection = conn.getConn();
            ps = connection.prepareStatement(sql_select);
            ps.setString(1, String.valueOf(ticketSeller.getTicket_seller_id()));
            ps.setString(2, ticketSeller.getTicket_seller_psw());
            rs = ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            CloseAll(connection, rs, ps);
        }
        return rs;
    }
}
