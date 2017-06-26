package dao;

import domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by hp on 2017/6/24.
 */
public class UserPackage {

    /**
     * 购票行为
     * @param user
     * @return
     */

    public int BuyTicketActionByUser (User user){
        int rs=0;
        PreparedStatement ps = null;
        Connection connection = null;
        try {
            Conn conn=new Conn();
            connection=conn.getConn();
            //问号占位
            String sql_insert="INSERT INTO buy_ticket(user_id, ticket_no, buy_ticket_time)VALUES(?,(SELECT max(ticket_no) FROM ticket ORDER BY ticket.ticket_no),curdate()) ;";
            //Statement接口提供了查询语句和获取查询结果的基本方法
            ps=connection.prepareStatement(sql_insert);
            ps.setString(1, String.valueOf(user.getUser_id()));
            rs=ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
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
            ps.setString(2,user.getUser_psw());
            rs = ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            CloseAll(connection, rs, ps);
        }
        return rs;
    }
    /**
     * 关闭流
     * @param cn
     * @param rs
     * @param ps
     */
    public void CloseAll(Connection cn, ResultSet rs, PreparedStatement ps) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (cn != null) {
            try {
                cn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
