package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String readHoldingSum() {
        System.out.println(ViewConstants.ASKING_HOLDING_SUM);
        String input = Console.readLine();
        System.out.println();
        return input;
    }

    public String readProductList() {
        System.out.println(ViewConstants.ASKING_PRODUCT_LIST);
        String input = Console.readLine();
        System.out.println();
        return input;
    }

    public String readInsertedMoney() {
        System.out.println(ViewConstants.ASKING_INSERTED_MONEY);
        String input = Console.readLine();
        System.out.println();
        return input;
    }

    public String readProductName() {
        System.out.println(ViewConstants.ASKING_PRODUCT_NAME);
        String input = Console.readLine();
        System.out.println();
        return input;
    }
}
