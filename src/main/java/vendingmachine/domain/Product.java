package vendingmachine.domain;

import vendingmachine.constant.ExceptionConstants;
import vendingmachine.constant.VendingMachineConstants;
import vendingmachine.util.Validator;

public class Product {
    private final String name;
    private final int price;
    private final int amount;

    public Product(String name, String price, String amount) {
        this.name = name;

        this.price = parse(price);
        Validator.validateLowerBound(this.price, VendingMachineConstants.LOWEST_PRICE);
        Validator.validateNumberIsMultipleOfTen(this.price);

        this.amount = parse(amount);
        Validator.validateLowerBound(this.amount, 0);
    }

    private int parse(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionConstants.INCORRECT_RANGE.getMessage());
        }
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int amount() {
        return amount;
    }
}
