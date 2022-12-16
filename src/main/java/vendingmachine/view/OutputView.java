package vendingmachine.view;

import vendingmachine.domain.Coin;
import vendingmachine.domain.CoinQuantities;
import vendingmachine.domain.InsertedMoney;

import java.util.List;
import java.util.stream.IntStream;

public class OutputView {

    public void printCoinQuantityList(CoinQuantities coinQuantities) {
        System.out.println(ViewConstants.COIN_QUANTITY_LIST);

        List<Coin> coinList = List.of(Coin.values());
        IntStream.range(0, 4)
                .forEach(i -> {
                    int amount = coinList.get(i).getAmount();
                    int quantity = coinQuantities.get(i);
                    System.out.printf(ViewConstants.COIN_QUANTITY, amount, quantity);
                    System.out.println();
                });
        System.out.println();
    }

    public void printInsertedMoney(InsertedMoney insertedMoney) {
        System.out.printf(ViewConstants.INSERTED_MONEY, insertedMoney.getInsertedMoney());
        System.out.println();
    }

    public void printChange(CoinQuantities coinQuantities, InsertedMoney insertedMoney) {
        System.out.println(ViewConstants.CHANGE);

        List<Coin> coinList = List.of(Coin.values());
        IntStream.range(0, 4)
                .forEach(i -> {
                    int amount = coinList.get(i).getAmount();
                    int quantity = Math.min(coinQuantities.get(i), insertedMoney.getInsertedMoney() / amount);
                    insertedMoney.useMoney(amount * quantity);
                    System.out.printf(ViewConstants.COIN_QUANTITY, amount, quantity);
                    System.out.println();
                });
    }

    public void printException(Exception e) {
        System.out.println(e.getMessage());
    }
}
