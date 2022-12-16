package vendingmachine.domain;

import java.util.List;

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

    public List<Integer> getCoinQuantities() {
        return coinQuantities.getCoinQuantities();
    }

    public int getInsertedMoney() {
        return insertedMoney.getInsertedMoney();
    }
}
