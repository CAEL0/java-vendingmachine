package vendingmachine.domain;

import java.util.List;
import java.util.OptionalInt;

public class VendingMachine {
    private CoinQuantities coinQuantities;
    private ProductList productList;
    private InsertedMoney insertedMoney;

    public void generateCoins(int holdingSum) {
        coinQuantities = new CoinQuantities(holdingSum);
    }

    public void addProducts(String productList) {
        this.productList = new ProductList(productList);
    }

    public void insertMoney(int insertedMoney) {
        this.insertedMoney = new InsertedMoney(insertedMoney);
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

    public List<Integer> getCoinQuantities() {
        return coinQuantities.getCoinQuantities();
    }

    public int getInsertedMoney() {
        return insertedMoney.getInsertedMoney();
    }
}
