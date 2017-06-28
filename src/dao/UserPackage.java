package dao;

import domain.RefundTicket;
import domain.Ticket;
import domain.TicketSeller;
import domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hp on 2017/6/24.
 */
public class UserPackage extends CloseDao{
    /**
     * 显示已够票包
     */
    public List<Ticket> SelectUserId(User user) {
        List<Ticket> list = new ArrayList<>();
        ResultSet rs = null;
        Connection dbc = null;
        PreparedStatement pst = null;
        Ticket ticket = null;
        String sql_select_id = "SELECT ticket.* FROM ticket,buy_ticket WHERE buy_ticket.ticket_no=ticket.ticket_no AND user_id=? AND ticket.ticket_no NOT IN (SELECT ticket_no FROM refund_ticket WHERE refund_ticket.user_id  = ?) UNION SELECT ticket.* FROM ticket,INFO_INPUT WHERE INFO_INPUT.ticket_no =ticket.ticket_no AND user_id =? AND ticket.ticket_no NOT IN (SELECT ticket_no FROM refund_ticket WHERE refund_ticket.user_id  = ?) ;";
        Conn conna = new Conn();
        try {
            dbc = conna.getConn();
            pst = dbc.prepareStatement(sql_select_id);
            pst.setInt(1, user.getUser_id());
            pst.setInt(2, user.getUser_id());
            pst.setInt(3, user.getUser_id());
            pst.setInt(4, user.getUser_id());

            rs = pst.executeQuery();
            if (rs.next()) {
                ticket = new Ticket();
                ticket.setTicket_name(rs.getString(1));
                ticket.setTicket_no(rs.getInt(2));
                ticket.setTicket_price(rs.getInt(3));
                ticket.setTicket_rate(rs.getInt(4));
                ticket.setTicket_type(rs.getString(5));
                ticket.setTicket_begin(rs.getDate(6));
                ticket.setTicket_end(rs.getDate(7));
                list.add(ticket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            CloseAll(dbc, rs, pst);
        }
        return list;
    }

    /**
     * 退票
     */
    public int RefundBehavior(RefundTicket refundTicket) {
        int rs = 0;
        PreparedStatement ps = null;
        Connection connection = null;
        try {
            Conn conn = new Conn();
            connection = conn.getConn();
            //问号占位
            String sql_insert = "INSERT INTO refund_ticket (user_id, ticket_no, refund_ticket) VALUES (?, ?, curdate());";
            //Statement接口提供了查询语句和获取查询结果的基本方法
            ps = connection.prepareStatement(sql_insert);
            ps.setString(1, String.valueOf(refundTicket.getUser_id()));
            ps.setString(2, String.valueOf(refundTicket.getTicket_no()));
            rs = ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            CloseAll(connection, null, ps);
        }
        return rs;
    }


    /**
     * 购票行为
     *
     * @param user
     * @return
     */

    public int BuyTicketActionByUser(User user) {
        int rs = 0;
        PreparedStatement ps = null;
        Connection connection = null;
        try {
            Conn conn = new Conn();
            connection = conn.getConn();
            //问号占位
            String sql_insert = "INSERT INTO buy_ticket(user_id, ticket_no, buy_ticket_time)VALUES(?,(SELECT max(ticket_no) FROM ticket ORDER BY ticket.ticket_no),curdate()) ;";
            //Statement接口提供了查询语句和获取查询结果的基本方法
            ps = connection.prepareStatement(sql_insert);
            ps.setString(1, String.valueOf(user.getUser_id()));
            rs = ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            CloseAll(connection, null, ps);
        }
        return rs;
    }


    public ResultSet DoLogin(User user) {
        String sql_select = "SELECT * FROM user WHERE user_id = ? AND user_psw = ?;";
        Conn conn = new Conn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection connection = null;
        try {
            connection = conn.getConn();
            ps = connection.prepareStatement(sql_select);
            ps.setString(1, String.valueOf(user.getUser_id()));
            ps.setString(2, user.getUser_psw());
            rs = ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            CloseAll(connection, rs, ps);
        }
        return rs;
    }
    public int InsertUser(User user){
        int rs=0;
        try {
            Conn conn=new Conn();
            Connection dbc=conn.getConn();//连接数据库
            String sql_insert="insert into user(user_name,user_psw,user_age) values(?,?,?)";
            PreparedStatement pst=dbc.prepareStatement(sql_insert);
            pst.setString(1, user.getUser_name());
            pst.setString(2, user.getUser_psw());
            pst.setString(3, user.getUser_age());
            rs=pst.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return rs;
    }
    public int InsertTicket_seller(TicketSeller ticketSeller){
        int rs=0;
        try {
            Conn conn=new Conn();
            Connection dbc=conn.getConn();//连接数据库
            String sql_insert="insert into ticket_seller(ticket_seller_name,ticket_seller_psw,ticket_seller_call) values(?,?,?)";
            PreparedStatement pst=dbc.prepareStatement(sql_insert);
            pst.setString(1, ticketSeller.getTicket_seller_name());
            pst.setString(2, ticketSeller.getTicket_seller_psw());
            pst.setString(3, ticketSeller.getTicket_seller_call());
            rs=pst.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return rs;
    }
    public ResultSet SelectId(int user_id){
        ResultSet rs=null;
        //User user=new User();
        try {
            Conn dbc=new Conn();
            Connection conn=dbc.getConn();
            String sql_select="select * from user where user_id=?";
            PreparedStatement pst=conn.prepareStatement(sql_select);
            pst.setInt(1, user_id);
            rs=pst.executeQuery();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return rs;
    }
    public int UpdateUser(User user) {
        int rs;

        try {
            Conn conn = new Conn();
            Connection dbc = conn.getConn();
            String sql_update = "update user set user_name=?,user_psw=?,user_age=? where user_id=?";
            PreparedStatement pst=dbc.prepareStatement(sql_update);
            pst.setString(1, user.getUser_name());
            pst.setString(2, user.getUser_psw());
            pst.setString(3, user.getUser_age());
            pst.setInt(4, user.getUser_id());
            rs = pst.executeUpdate();
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
