package dao;

import domain.Ticket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by hp on 2017/6/25.
 */
public class BuyPackage {

    public int BuyTicketAction (Ticket ticket){
        int rs=0;
        PreparedStatement ps = null;
        Connection connection = null;
        try {
            Conn conn=new Conn();
            connection=conn.getConn();
            //问号占位
            String sql_insert="INSERT INTO ticket (ticket_name, ticket_price, ticket_rate, ticket_type, ticket_begin, ticket_end) VALUES (\"二龙山\",20,10,?,\"2017-5-25\",\"2017-7-26\");";
            //Statement接口提供了查询语句和获取查询结果的基本方法
            ps=connection.prepareStatement(sql_insert);
            ps.setString(1,ticket.getTicket_type());
            rs=ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            CloseAll(connection, null, ps);
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
