package ServletPackage;

import dao.TicketSellerPackage;
import dao.UserPackage;
import domain.TicketSeller;
import domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

/**
 * Created by hp on 2017/6/7.
 */
@WebServlet(name = "AllLoginServlet" ,urlPatterns ="/ServletPackage/AllLoginServlet")
public class AllLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        //根据不同的用户类型进行传session
        HttpSession session = request.getSession();
        session.setAttribute("type",request.getParameter("user_type"));

        PrintWriter out = response.getWriter();
        ResultSet resultSet = null;
        String id = request.getParameter("user");
        String user_psw = request.getParameter("user_psw");
        String type = request.getParameter("user_type");

        out.println(" <link href=\"/css/CSS.css\" rel=\"stylesheet\" type=\"text/css\" />");

//        HttpSession session = req.setAttribute("User",username);
        //用session进行传值

        if (type.equals("visitor")) {
            User user = new User();
            user.setUser_id(Integer.parseInt(id));
            user.setUser_psw(user_psw);
            UserPackage userPackage = new UserPackage();
            resultSet = userPackage.DoLogin(user);
            if (resultSet != null) {
                //传递seesion值
                session.setAttribute("User_id",id);
//                out.print(session.getAttribute("student_start"));
                out.print("欢迎" + user.getUser_id() + "进入主页...");
                //用户登陆成功
                response.setHeader("refresh", "1,URL=../client/buy_ticket.jsp");
            }
        } else if (type.equals("seller")) {
            TicketSeller ticketSeller = new TicketSeller();
            ticketSeller.setTicket_seller_id(Integer.parseInt(id));
            ticketSeller.setTicket_seller_psw(user_psw);
            TicketSellerPackage ticketSellerPackage = new TicketSellerPackage();
            resultSet = ticketSellerPackage.DoLogin(ticketSeller);
            if (resultSet != null) {
                //传递seesion值
                session.setAttribute("User_id",id);
//                out.print(session.getAttribute("student_start"));
                out.print("欢迎" + ticketSeller.getTicket_seller_id()+ "进入主页...");
                //销售员登陆成功
                response.setHeader("refresh", "1,URL=../client/salePage.jsp");
            }
        } else {
            out.print("密码错误，三秒后将重回主页");
            response.setHeader("refresh", "2,URL=index.jsp");
        }
    }
}
