package db_interaction;

import java.util.Objects;

public class Order {

    public int order_id = 0;
    public String firm = "";
    public String stone_type = "";
    public int amount = 00000;
    public int due_date = 0;
    public String phase = "";
    public int price = 0;
    public boolean done = false;
    public String status = "";

    @Override
    public String toString() {
        return "{" + "order_id: " + order_id + " ; firm: " + firm + " ; stone_type: " + stone_type + " ; due_date: "
                + due_date + " ; phase: " + phase + " ; amount: " + amount + " ; Price: " + price + " ; done: " + done
                + " ; status: " + status + "}";
    }

    @Override
    public int hashCode() { // wird
        return Objects.hash(order_id);
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
}
