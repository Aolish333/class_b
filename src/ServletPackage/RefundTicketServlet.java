package ServletPackage;

import dao.UserPackage;
import domain.RefundTicket;

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
@WebServlet(name = "RefundTicketServlet" ,urlPatterns = "/ServletPackage/RefundTicketServlet")
public class RefundTicketServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        //根据不同的用户类型进行传session
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        String Ticket_id = request.getParameter("Ticket_id");
        String User_id = request.getParameter("User_id");
        RefundTicket refundTicket = new RefundTicket();
        refundTicket.setUser_id(Integer.parseInt(User_id));
        refundTicket.setTicket_no(Integer.parseInt(Ticket_id));
        UserPackage userPackage = new UserPackage();
        int rs = userPackage.RefundBehavior(refundTicket);
        if (rs ==1){
            out.print("退票成功..");
            response.setHeader("refresh", "1,URL=../client/dishonour.jsp?User_id="+User_id);
        }else {
            out.print("退票失败..");
            response.setHeader("refresh", "1,URL=../client/dishonour.jsp?User_id="+User_id);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }
}
