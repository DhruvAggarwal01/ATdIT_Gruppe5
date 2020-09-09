package db_interaction;
public class Order {
    

    public static int order_id = 0;
    public static String firm = "";
    public static String stone_type = ""; 
    public static String due_date = "";
    public static String status = "";
    public static int amount = 00000;
    public static int Price = 0;
    public static boolean done = false; // immer syncen mit Excel-DB (im Hinblick auf ausloggen)


    @Override
    public String toString() {
        return "{" + "order_id: " + order_id + " ; firm: " + firm + " ; stone_type: " + stone_type
                + " ; due_date: " + due_date + " ; status: " + status + " ; amount: " + amount + " ; Price: " + Price
                + " ; done: " + done + "}";
    }
}