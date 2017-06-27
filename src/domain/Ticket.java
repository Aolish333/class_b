package domain;

import java.util.Date;

/**
 * Created by hp on 2017/6/24.
 */
public class Ticket {
    public String getTicket_name() {
        return ticket_name;
    }

    public void setTicket_name(String ticket_name) {
        this.ticket_name = ticket_name;
    }

    public int getTicket_no() {
        return ticket_no;
    }

    public void setTicket_no(int ticket_no) {
        this.ticket_no = ticket_no;
    }

    public int getTicket_price() {
        return ticket_price;
    }

    public void setTicket_price(int ticket_price) {
        this.ticket_price = ticket_price;
    }

    public int getTicket_rate() {
        return ticket_rate;
    }

    public void setTicket_rate(int ticket_rate) {
        this.ticket_rate = ticket_rate;
    }

    public Date getTicket_begin() {
        return ticket_begin;
    }

    public void setTicket_begin(Date ticket_begin) {
        this.ticket_begin = ticket_begin;
    }

    public Date getTicket_end() {
        return ticket_end;
    }

    public void setTicket_end(Date ticket_end) {
        this.ticket_end = ticket_end;
    }

    public String getTicket_type() {
        return ticket_type;
    }

    public void setTicket_type(String ticket_type) {
        this.ticket_type = ticket_type;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticket_name='" + ticket_name + '\'' +
                ", ticket_no=" + ticket_no +
                ", ticket_price=" + ticket_price +
                ", ticket_rate=" + ticket_rate +
                ", ticket_begin=" + ticket_begin +
                ", ticket_end=" + ticket_end +
                ", ticket_type='" + ticket_type + '\'' +
                '}';
    }

    String ticket_name;
    int ticket_no;
    int ticket_price;
    int ticket_rate;
    Date ticket_begin;
    Date ticket_end;
    String ticket_type;
}
