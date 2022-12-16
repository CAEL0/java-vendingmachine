package vendingmachine.domain;

import vendingmachine.constant.ExceptionConstants;
import vendingmachine.constant.VendingMachineConstants;

import java.util.*;
import java.util.regex.Pattern;

public class VendingMachine {
    private CoinQuantities coinQuantities;
    private final List<Product> productList = new ArrayList<>();
    private InsertedMoney insertedMoney;

    public void generateCoins(int holdingSum) {
        coinQuantities = new CoinQuantities(holdingSum);
    }

    public void addProducts(String productList) {
        this.productList.clear();
        Arrays.stream(productList.split(VendingMachineConstants.PRODUCT_DELIMITER))
                .peek(this::validateProduct)
                .forEach(this::addProduct);

        validateDuplication();
    }

    private void validateProduct(String product) {
        if (!Pattern.matches(VendingMachineConstants.PRODUCT_REGEX, product)) {
            throw new IllegalArgumentException(ExceptionConstants.INCORRECT_PRODUCT_LIST.getMessage());
        }
    }

    private void addProduct(String product) {
        String parsedProduct = product.substring(1, product.length() - 1);
        List<String> productInfo = List.of(parsedProduct.split(VendingMachineConstants.DELIMITER));

        String name = productInfo.get(0);
        String price = productInfo.get(1);
        String amount = productInfo.get(2);

        productList.add(new Product(name, price, amount));
    }

    private void validateDuplication() {
        Set<String> productNames = new HashSet<>();
        productList.forEach(product -> productNames.add(product.getName()));
        if (productList.size() != productNames.size()) {
            throw new IllegalArgumentException(ExceptionConstants.DUPLICATED_PRODUCT_NAME.getMessage());
        }
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
