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
        while (true) {
            try {
                String holdingSum = inputView.readHoldingSum();
                vendingMachine.generateCoins(holdingSum);
                break;
            } catch (IllegalArgumentException e) {
                outputView.printException(e);
            }
        }
        outputView.printCoinQuantityList(vendingMachine.getCoinQuantities());
    }

    private void initProduct() {
        while (true) {
            try {
                String productList = inputView.readProductList();
                vendingMachine.addProducts(productList);
                return;
            } catch (IllegalArgumentException e) {
                outputView.printException(e);
            }
        }
    }

    private void insertMoney() {
        while (true) {
            try {
                String insertedMoney = inputView.readInsertedMoney();
                vendingMachine.insertMoney(insertedMoney);
                return;
            } catch (IllegalArgumentException e) {
                outputView.printException(e);
            }
        }
    }

    private void buy() {
        while (true) {
            try {
                String productName = inputView.readProductName();
                vendingMachine.buyProduct(productName);
                return;
            } catch (IllegalArgumentException e) {
                outputView.printException(e);
            }
        }
    }
}
