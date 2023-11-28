package utils;

public class NumberValidator {

    public static String ERROR_MESSAGE_FOR_INVALID_DOUBLE = "Invalid input, amount set to 0.";

    public static String ERROR_MESSAGE_FOR_INVALID_INTEGER = "Invalid option, try again!";


    public static double isDoubleValueValid(String input) {
        double output;
        try {
            output = Double.parseDouble(input);

        } catch (NumberFormatException nfe) {
            System.out.println(ERROR_MESSAGE_FOR_INVALID_DOUBLE);
            output = 0.0;
        }
        return output;
    }

    public static int isIntegerValueValid(String input) {
        int output;
        try {
            output = Integer.parseInt(input);

        } catch (NumberFormatException nfe) {
            System.out.println(ERROR_MESSAGE_FOR_INVALID_INTEGER);
            output = 0;
        }
        return output;
    }
}