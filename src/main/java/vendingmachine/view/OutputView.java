package vendingmachine.view;

import vendingmachine.domain.Coin;

import java.util.List;
import java.util.stream.IntStream;

public class OutputView {

    public void printCoinQuantityList(List<Integer> coinQuantities) {
        System.out.println(ViewConstants.COIN_QUANTITY_LIST);

        List<Coin> coinList = List.of(Coin.values());
        IntStream.range(0, 4)
                .forEach(i -> {
                    int amount = coinList.get(i).getAmount();
                    int quantity = coinQuantities.get(i);
                    System.out.printf(ViewConstants.COIN_QUANTITY, amount, quantity);
                    System.out.println();
                });
    }

    public void printInsertedMoney(int insertedMoney) {
        System.out.printf(ViewConstants.INSERTED_MONEY, insertedMoney);
        System.out.println();
    }

    public void printChange(List<Integer> coinQuantities, int insertedMoney) {
        System.out.println(ViewConstants.CHANGE);

        List<Coin> coinList = List.of(Coin.values());
        IntStream.range(0, 4)
                .forEach(i -> {
                    int amount = coinList.get(i).getAmount();
                    int quantity = Math.min(coinQuantities.get(i), insertedMoney / amount);
                    System.out.printf(ViewConstants.COIN_QUANTITY, amount, quantity);
                    System.out.println();
                });
    }
}
