import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Product[] inventory = new Product[100];
        int count = 0;

        while (true) {
            System.out.println("\n---- Shop Inventory System ----");
            System.out.println("1. Add new product");
            System.out.println("2. Display all products");
            System.out.println("3. Print total invoice");
            System.out.println("4. Exit");
            System.out.print("Choose: ");

            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {

                case 1:
                    if (count == inventory.length) {
                        System.out.println("Inventory is full!");
                        break;
                    }

                    System.out.print("Product name: ");
                    String name = input.nextLine();

                    double price;
                    do {
                        System.out.print("Price (>0): ");
                        price = input.nextDouble();
                    } while (price <= 0);

                    int qty;
                    do {
                        System.out.print("Quantity (>0): ");
                        qty = input.nextInt();
                    } while (qty <= 0);

                    double discount;
                    do {
                        System.out.print("Discount (0-100): ");
                        discount = input.nextDouble();
                    } while (discount < 0 || discount > 100);

                    Product p = new Product(name, price, qty, discount);
                    inventory[count] = p;
                    count++;

                    System.out.println("Product added successfully!");
                    break;

                case 2:
                    if (count == 0) {
                        System.out.println("No products in inventory.");
                    } else {
                        System.out.println("\n----- Inventory List -----");
                        for (int i = 0; i < count; i++) {
                            System.out.print((i + 1) + ". ");
                            inventory[i].display();
                        }
                    }
                    break;

                case 3:
                    if (count == 0) {
                        System.out.println("No products to print invoice.");
                    } else {
                        double totalDiscount = 0;
                        double totalFinal = 0;

                        System.out.println("\n----- Total Invoice -----");
                        for (int i = 0; i < count; i++) {
                            Product pr = inventory[i];
                            System.out.print((i + 1) + ". ");
                            pr.display();

                            double total = pr.getPrice() * pr.getQuantity();
                            double discountValue = total * pr.getDiscount() / 100;

                            totalDiscount += discountValue;
                            totalFinal += pr.getFinalPrice();
                        }

                        System.out.println("-------------------------");
                        System.out.println("Total items : " + count);
                        System.out.println("Total Discount : " + totalDiscount);
                        System.out.println("Total Final Price : " + totalFinal);
                    }
                    break;

                case 4:
                    System.out.println("Goodbye!");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
