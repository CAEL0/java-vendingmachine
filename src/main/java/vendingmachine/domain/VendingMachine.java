package vendingmachine.domain;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
    private final List<Integer> coinQuantities;
    private final List<Product> productList;

    public VendingMachine() {
        coinQuantities = new ArrayList<>();
        productList = new ArrayList<>();
    }
}
