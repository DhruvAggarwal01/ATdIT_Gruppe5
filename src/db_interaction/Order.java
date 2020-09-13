package db_interaction;

import java.util.Objects;

public class Order {

    public int order_id = 0;
    public String firm = "";
    public String stone_type = "";
    public int amount = 00000;
    //due_date noch int Wert tbd
    public int due_date = 0;
    public String phase = "";
    public int price = 0;
    public boolean done = false;
    public String status = "";
    public int rowcount = 1;

    @Override
    public String toString() {
        return "{" + "order_id: " + order_id + " ; firm: " + firm + " ; stone_type: " + stone_type + " ; due_date: "
                + due_date + " ; phase: " + phase + " ; amount: " + amount + " ; Price: " + price + " ; done: " + done
                + " ; status: " + status + "}";
    }

    @Override
    public int hashCode() { // wird
        return Objects.hash(order_id, firm,stone_type,amount,due_date,phase, price, done, status, rowcount);
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Order navIPC = (Order) obj;
        return Objects.equals(order_id, navIPC.order_id) && Objects.equals(firm, navIPC.firm)
                && Objects.equals(stone_type, navIPC.stone_type) && Objects.equals(amount, navIPC.amount)
                && Objects.equals(due_date, navIPC.due_date) && Objects.equals(phase, navIPC.phase)
                && Objects.equals(price, navIPC.price) && Objects.equals(done, navIPC.done)
                && Objects.equals(status, navIPC.status);
    }

    public int getOrder_id() {
        return this.order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getFirm() {
        return this.firm;
    }

    public void setFirm(String firm) {
        this.firm = firm;
    }

    public String getStone_type() {
        return this.stone_type;
    }

    public void setStone_type(String stone_type) {
        this.stone_type = stone_type;
    }

    public int getAmount() {
        return this.amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getDue_date() {
        return this.due_date;
    }

    public void setDue_date(int due_date) {
        this.due_date = due_date;
    }

    public String getPhase() {
        return this.phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean getisDone() {
        return this.done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
