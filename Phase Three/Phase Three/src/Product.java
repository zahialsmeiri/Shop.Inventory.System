public class Product {

    private String name;
    private double price;
    private int quantity;
    private double discount;
    private double finalPrice;

    public Product(String name, double price, int quantity, double discount) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.discount = discount;
        calculateFinalPrice();
    }

    private void calculateFinalPrice() {
        double total = price * quantity;
        finalPrice = total - (total * discount / 100);
    }

    // Getters
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public double getDiscount() { return discount; }
    public double getFinalPrice() { return finalPrice; }

    public void display() {
        System.out.println(name + " | Price: " + price +
                " | Qty: " + quantity +
                " | Discount: " + discount +
                " | Final: " + finalPrice);
    }
}
