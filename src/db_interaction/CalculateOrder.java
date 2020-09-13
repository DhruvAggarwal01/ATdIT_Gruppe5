package db_interaction;

import panels.EditOrder;
import db_interaction.Order;

public class CalculateOrder {

    public CalculateOrder(Order currentOrder) {
    
    }
    public int calculatePrice(Order currentOrder)  {    
        int price = 0;
        int amount = currentOrder.amount;
        switch (currentOrder.stone_type) {
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
}