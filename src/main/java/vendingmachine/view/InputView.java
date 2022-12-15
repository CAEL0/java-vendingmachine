package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.constant.ExceptionConstants;

public class InputView {

    public int readHoldingSum() {
        System.out.println(ViewConstants.ASKING_HOLDING_SUM);
        String input = Console.readLine();
        System.out.println();
        return parse(input);
    }

    private int parse(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionConstants.INCORRECT_RANGE.getMessage());
        }
    }

    public String readProductList() {
        System.out.println(ViewConstants.ASKING_PRODUCT_LIST);
        String input = Console.readLine();
        System.out.println();
        return input;
    }
}
