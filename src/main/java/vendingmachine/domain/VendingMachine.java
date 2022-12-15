package vendingmachine.domain;

import vendingmachine.constant.ExceptionConstants;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
    private final List<Integer> coinQuantities;
    private final List<Product> productList;

    public VendingMachine() {
        coinQuantities = new ArrayList<>();
        productList = new ArrayList<>();
    }

    private void validateNumberIsNonnegative(int number) {
        if (number < 0) {
            throw new IllegalArgumentException(ExceptionConstants.NOT_NEGATIVE.getMessage());
        }
    }
}
