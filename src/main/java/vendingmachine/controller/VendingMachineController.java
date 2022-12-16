package vendingmachine.controller;

import vendingmachine.domain.VendingMachine;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final VendingMachine vendingMachine = new VendingMachine();

    public void run() {
        init();
    }

    private void init() {
        int holdingSum = inputView.readHoldingSum();
        generateCoins(holdingSum);

        String productList = inputView.readProductList();
        vendingMachine.addProducts(productList);
    }

    private void generateCoins(int holdingSum) {
        while (true) {
            try {
                vendingMachine.generateCoins(holdingSum);
                return;
            } catch (IllegalArgumentException e) {
                outputView.printException(e);
            }
        }
    }
}
