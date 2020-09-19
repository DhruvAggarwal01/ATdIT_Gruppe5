package db_interaction;

import java.io.*;
import java.util.*;



public class OrdersSorter {

    static DBOrdersExtractor dbOrderExtractor;

    public OrdersSorter() {

        try {
            dbOrderExtractor = new DBOrdersExtractor("databases/DefaultCONTRACTS.xlsx");
        } catch (final IOException a) {
            a.printStackTrace();
        }
    }

    /**
     * 
     * @param status
     * @return Set<Order> gefiltert nach status
     */
    public static Set<Order> getUnfinishedOrders(final String status) {

        Set<Order> specificStatusOrders = new HashSet<Order>();
        Set<Order> unfinishedOrders = new HashSet<Order>();

        try {
            dbOrderExtractor = new DBOrdersExtractor("databases/DefaultCONTRACTS.xlsx");
            unfinishedOrders = dbOrderExtractor.getFilteredDBRowsToSet("done", false);
            specificStatusOrders = dbOrderExtractor.getFilteredDBRowsToSet("status", status);
            unfinishedOrders.retainAll(specificStatusOrders);
        } catch (IOException | IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return unfinishedOrders;
    }

    /**
     * 
     * @param status
     * @return Set<Order> gefiltert nach status
     */
    public static Set<Order> getAllOrders(final String status) {

        Set<Order> specificStatusOrders = new HashSet<Order>();
        Set<Order> allOrders = new HashSet<Order>();

        try {
            dbOrderExtractor = new DBOrdersExtractor("databases/DefaultCONTRACTS.xlsx");
            allOrders = dbOrderExtractor.getFilteredDBRowsToSet("rowcount", 1);
            specificStatusOrders = dbOrderExtractor.getFilteredDBRowsToSet("status", status);
            allOrders.retainAll(specificStatusOrders);

        } catch (IOException | IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return allOrders;
    }

}
