package vendingmachine.domain;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.constant.ExceptionConstants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class VendingMachine {
    private final List<Integer> coinQuantities = new ArrayList<>();
    private final List<Product> productList = new ArrayList<>();

    public VendingMachine(int holdingSum) {
        validateNumberIsNonnegative(holdingSum);
        validateNumberIsMultipleOfTen(holdingSum);
        generateCoins(holdingSum);
    }

    private void validateNumberIsNonnegative(int number) {
        if (number < 0) {
            throw new IllegalArgumentException(ExceptionConstants.NOT_NEGATIVE.getMessage());
        }
    }

    private void validateNumberIsMultipleOfTen(int number) {
        if (number % 10 != 0) {
            throw new IllegalArgumentException(ExceptionConstants.NOT_MULTIPLE_OF_TEN.getMessage());
        }
    }

    private void generateCoins(int holdingSum) {
        List<Integer> coinValues = Arrays.stream(Coin.values())
                .map(Coin::getAmount)
                .collect(Collectors.toList());

        while (holdingSum > 0) {
            int coin = Randoms.pickNumberInList(List.of(500, 100, 50, 10));
            if (holdingSum >= coin) {
                holdingSum -= coin;
                int index = coinValues.indexOf(coin);
                int quantity = coinQuantities.get(index);
                coinQuantities.set(index, quantity + 1);
            }
        }
    }
}
