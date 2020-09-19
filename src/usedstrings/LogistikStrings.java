package usedstrings;

public class LogistikStrings {

    private static final String onlyNumbersErrorMessage = "Field must only contain numbers";
    private static final String wrongAmountErrorMessage = "Amount cannot be more than 1000t";
    private static final String invalidNameErrorMessae = "Field must only contain characters from the Alphabet";

    public static String getonlyNumbersErrorMessage() {
        return onlyNumbersErrorMessage;
    }
    public static String getwrongAmountErrorMessage() {
        return wrongAmountErrorMessage;
    }
    public static String getinvalidNameErrorMessae () {
        return invalidNameErrorMessae;
    }}
