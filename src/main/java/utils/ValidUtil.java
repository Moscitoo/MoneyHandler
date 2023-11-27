package utils;

public class ValidUtil {

    public static double isDoubleValueValid(String input) {
        double output;
        try {
            output = Double.parseDouble(input);

        } catch (NumberFormatException nfe) {
            output = 0.0;
        }
        return output;
    }

    public static int isIntegerValueValid(String input) {
        int output;
        try {
            output = Integer.parseInt(input);

        } catch (NumberFormatException nfe) {
            output = 0;
        }
        return output;
    }
}