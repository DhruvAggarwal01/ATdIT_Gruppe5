package db_interaction;

import java.util.Objects;

/**
 * Diese Klasse
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class Order {

    public int order_id = 0;
    public String firm = "";
    public String stone_type = "";
    public int amount = 00000;
    public int due_date = 0; // due_date noch int Wert, in Version 2 mit date
    public String phase = "";
    public int price = 0;
    public boolean done = false;
    public String status = "onTime";
    public int rowcount = 1;

    /* ------------ Overriding zum möglichen Vergleich von Aufträgen ------------ */
    @Override
    public String toString() {
        return "{" + "order_id: " + order_id + " ; firm: " + firm + " ; stone_type: " + stone_type + " ; due_date: "
                + due_date + " ; phase: " + phase + " ; amount: " + amount + " ; Price: " + price + " ; done: " + done
                + " ; status: " + status + "}";
    }

    @Override
    public int hashCode() {
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
        return Objects.equals(order_id, navIPC.order_id);
    }

    /**
     * Getter-Methode für die Order_id
     * 
     * @return Order_id
     */
    public int getOrder_id() {
        return this.order_id;
    }

    /**
     * Setter-Methode für die Auftragsnummer
     * 
     * @param order_id Auftragsnummer
     */
    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    /**
     * Getter-Methode für die Firma
     * 
     * @return firm
     */
    public String getFirm() {
        return this.firm;
    }

    /**
     * Setter-Methode für die Firma
     * 
     * @param firm Firma
     */
    public void setFirm(String firm) {
        this.firm = firm;
    }

    /**
     * Getter-Methode für den stone_type
     * 
     * @return stone_type
     */
    public String getStone_type() {
        return this.stone_type;
    }

    /**
     * Setter-Methode für die Steinart
     * 
     * @param stone_type Steinart
     */
    public void setStone_type(String stone_type) {
        this.stone_type = stone_type;
    }

    /**
     * Getter-Methode für die Menge
     * 
     * @return amount
     */
    public int getAmount() {
        return this.amount;
    }

    /**
     * Setter-Methode für die Menge
     * 
     * @param amount Menge
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }

    /**
     * Getter-Methode für das due_date
     * 
     * @return due_date
     */
    public int getDue_date() {
        return this.due_date;
    }

    /**
     * Setter-Methode für das Lieferdatum
     * 
     * @param due_date Lieferdatum
     */
    public void setDue_date(int due_date) {
        this.due_date = due_date;
    }

    /**
     * Getter-Methode für die phase
     * 
     * @return phase
     */
    public String getPhase() {
        return this.phase;
    }

    /**
     * Setter-Methode für die Phase
     * 
     * @param phase
     */
    public void setPhase(String phase) {
        this.phase = phase;
    }

    /**
     * Getter-Methode für den Preis
     * 
     * @return price
     */
    public int getPrice() {
        return this.price;
    }

    /**
     * Setter-Methode für den Preis
     * 
     * @param price Preis
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * Getter-Methode für done
     * 
     * @return done
     */
    public boolean getisDone() {
        return this.done;
    }

    /**
     * Setter-Methode für done, Abgeschlossenheit des Auftrags
     * 
     * @param done
     */
    public void setDone(boolean done) {
        this.done = done;
    }

    /**
     * Getter-Methode für den status
     * 
     * @return status
     */
    public String getStatus() {
        return this.status;
    }

    /**
     * Setter-Methode für den status
     * 
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
    }

}
