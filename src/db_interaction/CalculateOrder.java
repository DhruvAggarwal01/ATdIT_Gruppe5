package db_interaction;

import java.util.Date;

/**
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class CalculateOrder {

    public CalculateOrder(Order currentOrder) {
        // tbd?
    }

    public static int calculatePrice(Order currentOrder) {
        int price = 0;
        int amount = currentOrder.getAmount();
        switch (currentOrder.getStone_type()) {
            case "Sandstein":
                price = amount * 75;
                break;
            case "Kalksteine":
                price = amount * 130;
                break;
            case "Granite":
                price = amount * 150;
                break;
            case "Basalte":
                price = amount * 300;
                break;
            case "Schiefer":
                price = amount * 400;
                break;
            default:
                price = amount * 0;
                break;
        }
        return price;
    }

    public static String calculateStatus(Order currentOrder) {
        String status = "";
        String phase = currentOrder.getPhase();
        int due_date = currentOrder.getDue_date();
        Date actualDate = new Date();
        switch (currentOrder.getPhase()) {
            case "Planung":

                break;
            case "Sprengung":

                break;
            case "Transport":

                break;
            case "Geliefert":

                break;
            default:

                break;
        }
        return status;
    }
}
