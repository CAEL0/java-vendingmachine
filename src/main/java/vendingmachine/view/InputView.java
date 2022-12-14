package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.constant.ExceptionConstants;

public class InputView {

    public int readHoldingSum() {
        System.out.println(ViewConstants.ASKING_HOLDING_SUM);
        String input = Console.readLine();
        System.out.println();

        int parsedInput = parse(input);
        isNonnegative(parsedInput);
        return parsedInput;
    }

    private int parse(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionConstants.INCORRECT_RANGE.getMessage());
        }
    }

    private void isNonnegative(int number) {
        if (number < 0) {
            throw new IllegalArgumentException(ExceptionConstants.NOT_NEGATIVE.getMessage());
        }
    }
}
