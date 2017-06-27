package ServletPackage;

import dao.BuyPackage;
import dao.TicketSellerPackage;
import domain.InfoInput;
import domain.Ticket;

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
@WebServlet(name = "SalesRegistrationServlet", urlPatterns = "/ServletPackage/SalesRegistrationServlet")
public class SalesRegistrationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
//        获取seesion
        HttpSession session = request.getSession();
        String  saler_id = (String) session.getAttribute("User_id");
        String ticket_type = request.getParameter("ticket_type");
        //用户id
        String user_id = request.getParameter("user_id");
        Ticket ticket = new Ticket();
        ticket.setTicket_type(ticket_type);

        InfoInput infoInput = new InfoInput();
        infoInput.setTicket_seller_id(Integer.parseInt(saler_id));
        infoInput.setUser_id(Integer.parseInt(user_id));
        BuyPackage buyPackage = new BuyPackage();

        int rs1 = buyPackage.BuyTicketAction(ticket);

        TicketSellerPackage ticketSellerPackage = new TicketSellerPackage();
        int rs2 = ticketSellerPackage.InsertInfromation(infoInput);

        out.println(" <link href=\"/css/CSS.css\" rel=\"stylesheet\" type=\"text/css\" />");

        if (rs2 == 1){
            out.println("登记成功...");
            response.setHeader("refresh", "1,URL=../client/statisticsPage.jsp?User_id="+user_id);

        }else {
            out.println("登记失败...");
            response.setHeader("refresh", "1,URL=../client/salePage.jsp");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
