package ServletPackage;

import dao.BuyPackage;
import dao.UserPackage;
import domain.Ticket;
import domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by hp on 2017/6/26.
 */

@WebServlet(name = "BuyTicketServlet", urlPatterns = "/ServletPackage/BuyTicketServlet")

public class BuyTicketServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
//        获取seesion
        HttpSession session = request.getSession();
        String  user_id = (String) session.getAttribute("User_id");

        String ticket_type = String.valueOf(request.getParameter("ticket_type"));
        //用户设置
        User user = new User();
        user.setUser_id(Integer.parseInt(user_id));
        //设置票的类型
        Ticket ticket = new Ticket();
        ticket.setTicket_type(ticket_type);
        BuyPackage buyPackage = new BuyPackage();
        UserPackage userPackage = new UserPackage();
        int rs1 = buyPackage.BuyTicketAction(ticket);
        int rs2 = userPackage.BuyTicketActionByUser(user);
        out.println(" <link href=\"/css/CSS.css\" rel=\"stylesheet\" type=\"text/css\" />");

        if (rs2 == 1){
            out.println("购票成功...");
            response.setHeader("refresh", "1,URL=../client/dishonour.jsp?User_id="+user_id);

        }else {
            out.println("购票失败...");
            response.setHeader("refresh", "1,URL=../client/buy_ticket.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
