package vendingmachine.domain;

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

    public int getInsertedMoney() {
        return insertedMoney;
    }
}
