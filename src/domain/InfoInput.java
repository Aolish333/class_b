package domain;

/**
 * Created by hp on 2017/6/25.
 */
public class InfoInput {
    public int getTicket_seller_id() {
        return ticket_seller_id;
    }

    public void setTicket_seller_id(int ticket_seller_id) {
        this.ticket_seller_id = ticket_seller_id;
    }

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

    public String getSaleDate() {
        return SaleDate;
    }

    public void setSaleDate(String saleDate) {
        SaleDate = saleDate;
    }

    @Override
    public String toString() {
        return "InfoInput{" +
                "ticket_seller_id=" + ticket_seller_id +
                ", user_id=" + user_id +
                ", ticket_no=" + ticket_no +
                ", SaleDate='" + SaleDate + '\'' +
                '}';
    }

    int ticket_seller_id;
    int user_id;
    int ticket_no;
    String SaleDate;
}
