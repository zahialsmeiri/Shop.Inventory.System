
package Scr;
import java.util.Scanner;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
                //class الادخال
                Scanner input = new Scanner(System.in);
                input.useLocale(Locale.US);
                //واجهة البداية
                System.out.println("======================================");
                System.out.println("-------[SHOP INVENTORY SYSTEM]--------");
                System.out.println("======================================");
                //أدخالات المستخدم
                System.out.print(">> Enter Product Name  : ");
                String productName = input.nextLine();

                System.out.print(">> Enter Unit Price  : ");
                double unitPrice = input.nextDouble();

                System.out.print(">> Enter Quantity Purchased : ");
                int quantity = input.nextInt();
                //دالة الشرط لادخالات السعر و الكمية
                if (unitPrice <= 0 || quantity <= 0) {
                    System.out.println("\n[ ERROR ] Invalid Input Detected");
                    System.out.println("--------------------------------------");
                    System.out.println("• Price and quantity must be > 0");
                    return;
                }
                //تعريف متغير السعر والخصم
                double total = unitPrice * quantity;
                double discount = 0;
                // دالة الشرط الخاصة بحساب الخصم
                if (quantity >= 10) {
                    discount = total * 0.10;
                }
                //متغير السعر الكلي
                double finalPrice = total - discount;
                //اوامر طباعة الفاتورة
                System.out.println("\n============== INVOICE ===============");
                System.out.println("Product Name   : " + productName);
                System.out.println("Unit Price     : "+ unitPrice);
                System.out.println("Quantity       : "+ quantity);
                System.out.println("--------------------------------------");
                System.out.println("Discount       : "+ discount);
                System.out.println("Final Price    : "+ finalPrice);
                System.out.println("======================================");
            }
        }