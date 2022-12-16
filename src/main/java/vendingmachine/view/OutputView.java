package vendingmachine.view;

import vendingmachine.domain.Coin;
import vendingmachine.domain.VendingMachine;

import java.util.List;
import java.util.stream.IntStream;

public class OutputView {

    public void printCoinQuantityList(VendingMachine vendingMachine) {
        System.out.println(ViewConstants.COIN_QUANTITY_LIST);

        List<Coin> coinList = List.of(Coin.values());
        List<Integer> coinQuantities = vendingMachine.getCoinQuantities();
        IntStream.range(0, 4)
                .forEach(i -> {
                    int amount = coinList.get(i).getAmount();
                    int quantity = coinQuantities.get(i);
                    System.out.printf(ViewConstants.COIN_QUANTITY, amount, quantity);
                });
    }
}
