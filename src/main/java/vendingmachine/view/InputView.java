package vendingmachine.view;

import vendingmachine.constant.ExceptionConstants;

public class InputView {

    private int parse(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionConstants.INCORRECT_RANGE.getMessage());
        }
    }
}
