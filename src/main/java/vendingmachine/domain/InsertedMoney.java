package vendingmachine.domain;

import vendingmachine.constant.ExceptionConstants;
import vendingmachine.util.Validator;

public class InsertedMoney {
    private int insertedMoney;

    public InsertedMoney(int insertedMoney) {
        Validator.validateLowerBound(insertedMoney, 0);
        Validator.validateNumberIsMultipleOfTen(insertedMoney);
        this.insertedMoney = insertedMoney;
    }

    public void useMoney(int price) {
        insertedMoney -= price;
    }

    public void validateUsingMoney(int price) {
        if (insertedMoney < price) {
            throw new IllegalArgumentException(ExceptionConstants.NOT_ENOUGH_MONEY.getMessage());
        }
    }

    public int getInsertedMoney() {
        return insertedMoney;
    }
}
