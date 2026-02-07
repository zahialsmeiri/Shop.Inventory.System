
import java.util.Locale;
import java.util.Scanner;

public class PhaseTwo {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        input.useLocale(Locale.US);

        // تعرف المتغيرات
        String productName = "";
        double unitPrice = 0;
        int quantity = 0;
        double discount = 0;
        double finalPrice = 0;

        boolean Transaction = false;
        int choice;

        do {
            //واجهة البداية
            System.out.println("----- Welcome To The Shop Inventory System -----");
            System.out.println("1. New Product Transaction");
            System.out.println("2. Print Invoice");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
          
            choice = input.nextInt();
            input.nextLine();
          
            if (choice == 1) {
               //عملية شرائية
                System.out.print("Product Name : ");
                productName = input.nextLine();

                System.out.print("Product Unit Price : ");
                unitPrice = input.nextDouble();

                System.out.print("Quantity Purchased : ");
                quantity = input.nextInt();

                // عملية تحقق من البيانات
                if (unitPrice <= 0 || quantity <= 0) {
                    System.out.println("Error:");
                    System.out.println("Invalid input detected.");
                    System.out.println("Product price and quantity must be greater than zero.");
                } else {
                    // عملية حساب الخصم وتعريف متغير سعر النهائي
                    double totalPrice = unitPrice * quantity;
                    discount = totalPrice * 0.10;
                    finalPrice = totalPrice - discount;

                    Transaction = true;
                }

            } else if (choice == 2) {
                // اوامر طباعة الفاتورة
                if (Transaction) {
                    System.out.println("----- Invoice -----");
                    System.out.println("Product : " + productName);
                    System.out.println("Unit Price : " + unitPrice);
                    System.out.println("Quantity : " + quantity);
                    System.out.println("Discount : " + discount);
                    System.out.println("Final Price : " + finalPrice);
                } else {
                    System.out.println("Message:");
                    System.out.println("No transaction found. Please create a transaction first.");
                }

            } else if (choice != 0) {
                // طباعة الخطئ عند الادخال
                System.out.println("Error:");
                System.out.println("Invalid menu choice. Please select a valid option.");
            }

            System.out.println();

        } while (choice != 0);

        input.close();
    }
}
