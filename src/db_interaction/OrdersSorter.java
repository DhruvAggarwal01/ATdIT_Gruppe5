package db_interaction;

import java.util.*;
import javax.swing.*;

import exceptions.DatabaseConnectException;
import usedstrings.LogistikStrings;

/**
 * tbd
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class OrdersSorter {

    static DBGenericExtractor<Order> dbOrderExtractor;

    public OrdersSorter() {
        try {
            dbOrderExtractor = new DBGenericExtractor<Order>(LogistikStrings.getOrdersDatabaseString(), new Order());
        } catch (DatabaseConnectException dce) {
            JPanel exceptionPanel = dce.getExceptionPanel();
            JOptionPane.showMessageDialog(new JFrame(), exceptionPanel, "Error: " + dce.getClass(),
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * tbd
     * 
     * @param status
     * @return Set<Order> gefiltert nach status
     */
    public static Set<Order> getUnfinishedOrders(final String status) {
        Set<Order> specificStatusOrders = new HashSet<Order>();
        Set<Order> unfinishedOrders = new HashSet<Order>();
        try {
            dbOrderExtractor = new DBGenericExtractor<Order>(LogistikStrings.getOrdersDatabaseString(), new Order());
            unfinishedOrders = dbOrderExtractor.getFilteredDBRowsToSet("done", false);
            specificStatusOrders = dbOrderExtractor.getFilteredDBRowsToSet("status", status);
            unfinishedOrders.retainAll(specificStatusOrders);
        } catch (DatabaseConnectException dce) {
            JPanel exceptionPanel = dce.getExceptionPanel();
            JOptionPane.showMessageDialog(new JFrame(), exceptionPanel, "Error: " + dce.getClass(),
                    JOptionPane.ERROR_MESSAGE);
        }
        return unfinishedOrders;
    }

    /**
     * tbd
     * 
     * @param status
     * @return Set<Order> gefiltert nach status
     */
    public static Set<Order> getAllOrders(final String status) {
        Set<Order> specificStatusOrders = new HashSet<Order>();
        Set<Order> allOrders = new HashSet<Order>();
        try {
            dbOrderExtractor = new DBGenericExtractor<Order>(LogistikStrings.getOrdersDatabaseString(), new Order());
            allOrders = dbOrderExtractor.getFilteredDBRowsToSet("rowcount", 1);
            specificStatusOrders = dbOrderExtractor.getFilteredDBRowsToSet("status", status);
            allOrders.retainAll(specificStatusOrders);
        } catch (DatabaseConnectException dce) {
            JPanel exceptionPanel = dce.getExceptionPanel();
            JOptionPane.showMessageDialog(new JFrame(), exceptionPanel, "Error: " + dce.getClass(),
                    JOptionPane.ERROR_MESSAGE);
        }
        return allOrders;
    }

}
