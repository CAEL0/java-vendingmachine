package vendingmachine.domain;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.util.Validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CoinQuantities {
    private final List<Integer> coinQuantities = new ArrayList<>();

    public CoinQuantities(int holdingSum) {
        Validator.validateLowerBound(holdingSum, 0);
        Validator.validateNumberIsMultipleOfTen(holdingSum);
        generateCoins(holdingSum);
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

    public List<Integer> getCoinQuantities() {
        return coinQuantities;
    }
}
