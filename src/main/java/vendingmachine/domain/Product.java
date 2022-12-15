package vendingmachine.domain;

public class Product {
    private final String name;
    private final int price;
    private final int amount;

    public Product(String name, int price, int amount) {
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int amount() {
        return amount;
    }
}
