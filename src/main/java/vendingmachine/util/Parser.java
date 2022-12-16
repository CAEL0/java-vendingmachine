package vendingmachine.util;

import vendingmachine.constant.ExceptionConstants;

public class Parser {

    public static int parse(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionConstants.INCORRECT_RANGE.getMessage());
        }
    }
}
