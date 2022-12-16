package vendingmachine.controller;

import vendingmachine.domain.VendingMachine;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final VendingMachine vendingMachine = new VendingMachine();

    public void run() {
        initCoin();
        initProduct();
        insertMoney();
        while (vendingMachine.canBuy()) {
            outputView.printInsertedMoney(vendingMachine.getInsertedMoney());
            buy();
        }
        outputView.printChange(vendingMachine.getCoinQuantities(), vendingMachine.getInsertedMoney());
    }

    private void initCoin() {
        String holdingSum = inputView.readHoldingSum();
        while (true) {
            try {
                vendingMachine.generateCoins(holdingSum);
                break;
            } catch (IllegalArgumentException e) {
                outputView.printException(e);
            }
        }
        outputView.printCoinQuantityList(vendingMachine.getCoinQuantities());
    }

    private void initProduct() {
        String productList = inputView.readProductList();
        while (true) {
            try {
                vendingMachine.addProducts(productList);
                return;
            } catch (IllegalArgumentException e) {
                outputView.printException(e);
            }
        }
    }

    private void insertMoney() {
        String insertedMoney = inputView.readInsertedMoney();
        while (true) {
            try {
                vendingMachine.insertMoney(insertedMoney);
                return;
            } catch (IllegalArgumentException e) {
                outputView.printException(e);
            }
        }
    }

    private void buy() {
        String productName = inputView.readProductName();
        while (true) {
            try {
                vendingMachine.buyProduct(productName);
                return;
            } catch (IllegalArgumentException e) {
                outputView.printException(e);
            }
        }
    }
}
