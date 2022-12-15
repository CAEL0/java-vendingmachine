package vendingmachine.domain;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.constant.ExceptionConstants;
import vendingmachine.constant.VendingMachineConstants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class VendingMachine {
    private final List<Integer> coinQuantities = new ArrayList<>();
    private final List<Product> productList = new ArrayList<>();

    public void generateCoins(int holdingSum) {
        validateNumberIsNonnegative(holdingSum);
        validateNumberIsMultipleOfTen(holdingSum);
        List<Integer> coinValues = Arrays.stream(Coin.values())
                .map(Coin::getAmount)
                .collect(Collectors.toList());

        while (holdingSum > 0) {
            int coin = Randoms.pickNumberInList(List.of(500, 100, 50, 10));
            if (holdingSum >= coin) {
                holdingSum -= coin;
                int index = coinValues.indexOf(coin);
                int quantity = coinQuantities.get(index);
                coinQuantities.set(index, quantity + 1);
            }
        }
    }

    private void validateNumberIsNonnegative(int number) {
        if (number < 0) {
            throw new IllegalArgumentException(ExceptionConstants.NOT_NEGATIVE.getMessage());
        }
    }

    private void validateNumberIsMultipleOfTen(int number) {
        if (number % 10 != 0) {
            throw new IllegalArgumentException(ExceptionConstants.NOT_MULTIPLE_OF_TEN.getMessage());
        }
    }

    private void validateProductList(String productList) {
        Arrays.stream(productList.split(VendingMachineConstants.PRODUCT_DELIMITER))
                .forEach(this::validateProduct);
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
}
