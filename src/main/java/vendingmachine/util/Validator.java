package vendingmachine.util;

import vendingmachine.constant.ExceptionConstants;

public class Validator {

    public static void validateNumberIsMultipleOfTen(int number) {
        if (number % 10 != 0) {
            throw new IllegalArgumentException(ExceptionConstants.NOT_MULTIPLE_OF_TEN.getMessage());
        }
    }
    public static void validateLowerBound(int number, int lowerBound) {
        if (number < lowerBound) {
            throw new IllegalArgumentException();
        }
    }
}