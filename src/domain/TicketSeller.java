package domain;

/**
 * Created by hp on 2017/6/25.
 */
public class TicketSeller {

    public int getTicket_seller_id() {
        return ticket_seller_id;
    }

    public void setTicket_seller_id(int ticket_seller_id) {
        this.ticket_seller_id = ticket_seller_id;
    }

    public String getTicket_seller_psw() {
        return ticket_seller_psw;
    }

    public void setTicket_seller_psw(String ticket_seller_psw) {
        this.ticket_seller_psw = ticket_seller_psw;
    }

    public String getTicket_seller_call() {
        return ticket_seller_call;
    }

    public void setTicket_seller_call(String ticket_seller_call) {
        this.ticket_seller_call = ticket_seller_call;
    }

    public String getTicket_seller_name() {
        return ticket_seller_name;
    }

    public void setTicket_seller_name(String ticket_seller_name) {
        this.ticket_seller_name = ticket_seller_name;
    }

    int ticket_seller_id;
    String ticket_seller_psw;
    String ticket_seller_call;
    String ticket_seller_name;

}
