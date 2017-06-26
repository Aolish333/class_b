package domain;

import java.util.Date;

/**
 * Created by hp on 2017/6/25.
 */
public class BuyTicket {
    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getTicket_no() {
        return ticket_no;
    }

    public void setTicket_no(int ticket_no) {
        this.ticket_no = ticket_no;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    int user_id;
    int ticket_no;
    Date date;
}
