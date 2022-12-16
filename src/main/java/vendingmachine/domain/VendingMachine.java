package vendingmachine.domain;

import vendingmachine.util.Parser;

import java.util.List;
import java.util.OptionalInt;

public class VendingMachine {
    private CoinQuantities coinQuantities;
    private ProductList productList;
    private InsertedMoney insertedMoney;

    public void generateCoins(String holdingSum) {
        coinQuantities = new CoinQuantities(Parser.parse(holdingSum));
    }

    public void addProducts(String productList) {
        this.productList = new ProductList(productList);
    }

    public void insertMoney(String insertedMoney) {
        this.insertedMoney = new InsertedMoney(Parser.parse(insertedMoney));
    }

    public void buyProduct(String productName) {
        Product product = productList.getProduct(productName);
        insertedMoney.useMoney(product.getPrice());
        product.buy();
    }

    public boolean canBuy() {
        OptionalInt minimumPrice = productList.getMinimumPrice();
        return minimumPrice.isPresent() && minimumPrice.getAsInt() <= insertedMoney.getInsertedMoney();
    }

    public CoinQuantities getCoinQuantities() {
        return coinQuantities;
    }

    public InsertedMoney getInsertedMoney() {
        return insertedMoney;
    }
}
