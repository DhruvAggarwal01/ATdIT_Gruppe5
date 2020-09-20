package usedstrings;

public class LogistikStrings {

    /* ----------------------- Getter/Setter-Methoden --------------------------- */

    private static final String ordersDatabaseString = "databases/DefaultCONTRACTS.xlsx";
    private static final String logisticsString = "Logistik";
    private static final String displayAllString = "DisplayAll";
    private static final String editOrderString= "EditOrder";
    private static final String emptyString = "";
    

    /* ----------------------- Order Panels Strings--------------------------- */

    private static final String displayAllText = "Zeige auch abgeschlossene Aufträge an";
    private static final String createOrderText = "create Order";
    private static final String searchOrderText = "search";
    private static final String onTimeString = "onTime";
    private static final String atRiskString = "atRisk";
    private static final String overdueString = "overdue";
    private static final String onTimeText = "Order on Time";
    private static final String atRiskText = "Order at Risk";
    private static final String overdueText = "Order Overdue";
    private static final String onTimeDescription = "These Ordes are on Time!";
    private static final String atRiskDescription = "These Ordes are at Risk of delivering on Time!";
    private static final String overdueDescription = "These Ordes are overdue!";


    /* ----------------------- Edit/ Show Order Strings --------------------------- */

    private static final String firmString = "Firma:";
    private static final String stoneTypeString = "Steinart";
    private static final String stoneTypeOneString = "Sandstein";
    private static final String stoneTypeTwoSring = "Kalkstein";
    private static final String stoneTypeThreeString = "Granite";
    private static final String stoneTypeFourString = "Basalte";
    private static final String stoneTypeFiveString = "Schiefer";
    private static final String amountString = "Menge";
    private static final String priceString = "Preis";
    private static final String priceDescription = "Der Preis wird berechnet";
    private static final String dueDateString = "Lieferdatum";
    private static final String phaseString = "Phase";
    private static final String phasePlanningString = "Planung";
    private static final String phaseBombingString = "Sprengung";
    private static final String phaseTransportString = "Transport";
    private static final String phaseDeliveredSttring = "Geliefert";

    private static final String tonString = "Tonnen";
    private static final String euroSign= "€";
    private static final String orderDoneText= "Auftrag abgeschlossen: ";
    private static final String orderDoneDescription = "Der Auftrag ist abgeschlossen";
    private static final String orderNotDoneDescription= "Der ist Auftrag noch nicht abgeschlossen";
    private static final String editOrderText = "Auftrag bearbeiten";
    private static final String backString = "Zurück";
    private static final String saveString = "Speichern";

    /* ----------------------- Verifier Strings--------------------------- */

    private static final String onlyNumbersErrorMessage = "Field must only contain numbers";
    private static final String wrongAmountErrorMessage = "Amount cannot be more than 1000t";
    private static final String invalidNameErrorMessae = "Field must only contain characters from the Alphabet";

   
    /* ----------------------- Getter Methoden --------------------------- */
   
       public static String getEmptyString() {
        return emptyString;
    }

    public static String getSaveString() {
        return saveString;
    }
      
    public static String getEditOrderString() {
        return editOrderString;
    }
    
    public static String getTonString() {
        return tonString;
    }
    public static String getEuroSign() {
        return euroSign;
    }
   
    public static String getOrderDoneText() {
        return orderDoneText;
    }
   
    public static String getOrderDoneDescription() {
        return orderDoneDescription;
    }
   
    public static String getOrderNotDoneDescription() {
        return orderNotDoneDescription;
    }
   
    public static String getEditOrderText() {
        return editOrderText;
    }

    public static String getFirmString() {
        return firmString;
    }
   
    public static String getAmountString() {
        return amountString;
    }
   
    public static String getPriceString() {
        return priceString;
    }

    public static String getPriceDescription() {
        return priceDescription;
    }
   
    public static String getDueDateString() {
        return dueDateString;
    }
    public static String getPhaseString() {
        return phaseString;
    }
   
    public static String getPhasePlanningString() {
        return phasePlanningString;
    }
    public static String getPhaseBombingString()  {
        return phaseBombingString;
    }
    public static String getPhaseTransportString() {
        return phaseTransportString;
    }
    public static String getPhaseDeliveredSttring() {
        return phaseDeliveredSttring;
    }
   


    public static String getBackString() {
        return backString;
    }
    public static String getStoneTypeString() {
        return stoneTypeString;
    }

    public static String getStoneTypeOneString() {
        return stoneTypeOneString;
    }
    public static String getStoneTypeTwoSring() {
        return stoneTypeTwoSring;
    }
    public static String getStoneTypeThreeString() {
        return stoneTypeThreeString;
    }
    public static String getStoneTypeFourString() {
        return stoneTypeFourString;
    }
   
    public static String getStoneTypeFiveString() {
        return stoneTypeFiveString;
    }
   
   
   
       /* ----------------------- Getter/Setter-Methoden --------------------------- */
   
   
    public static String getOrdersDatabaseString() {
        return ordersDatabaseString;
    }

    public static String getOnlyNumbersErrorMessage() {
        return onlyNumbersErrorMessage;
    }

    public static String getWrongAmountErrorMessage() {
        return wrongAmountErrorMessage;
    }

    public static String getInvalidNameErrorMessae() {
        return invalidNameErrorMessae;
    }

    public static String getDisplayAllText() {
        return displayAllText;
    }

    public static String getCreateOrderText() {
        return createOrderText;
    }

    public static String getSearchOrderText() {
        return searchOrderText;
    }

    public static String getLogisticsString() {
        return logisticsString;
    }

    public static String getDisplayAllString() {
        return displayAllString;
    }

    public static String getOnTimeString() {
        return onTimeString;
    }

    public static String getAtRiskString() {
        return atRiskString;
    }

    public static String getOverdueString() {
        return overdueString;
    }

    public static String getOnTimeText() {
        return onTimeText;
    }

    public static String getAtRiskText() {
        return atRiskText;
    }

    public static String getOverdueText() {
        return overdueText;
    }

    public static String getOnTimeDescription() {
        return onTimeDescription;
    }

    public static String getAtRiskDescription() {
        return atRiskDescription;
    }

    public static String getOverdueDescription() {
        return overdueDescription;
    }

}
