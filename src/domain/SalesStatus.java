package domain;

/**
 * Created by hp on 2017/6/26.
 */
public class SalesStatus {


    public int getMonthly() {
        return Monthly;
    }

    public void setMonthly(int monthly) {
        Monthly = monthly;
    }

    public String getSales_type() {
        return sales_type;
    }

    public void setSales_type(String sales_type) {
        this.sales_type = sales_type;
    }

    public int getSales_earning() {
        return sales_earning;
    }

    public void setSales_earning(int sales_earning) {
        this.sales_earning = sales_earning;
    }

    public int getSales_price() {
        return sales_price;
    }

    public void setSales_price(int sales_price) {
        this.sales_price = sales_price;
    }

    public int getSales_amount() {
        return sales_amount;
    }

    public void setSales_amount(int sales_amount) {
        this.sales_amount = sales_amount;
    }

    @Override
    public String toString() {
        return "SalesStatus{" +
                "Monthly=" + Monthly +
                ", sales_type='" + sales_type + '\'' +
                ", sales_earning=" + sales_earning +
                ", sales_price=" + sales_price +
                ", sales_amount=" + sales_amount +
                '}';
    }

    int Monthly;
    String sales_type;
    int sales_earning;
    int sales_price;
    int sales_amount;
}
