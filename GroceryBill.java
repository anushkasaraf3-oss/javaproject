 import java.util.ArrayList;
import java.util.Scanner;

class GroceryItem {
    private String name;
    private double price;
    private int quantity;

    public GroceryItem(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return price * quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}

class Bill {
    private ArrayList<GroceryItem> items = new ArrayList<>();

    public void addItem(GroceryItem item) {
        items.add(item);
    }

    public double calculateTotal() {
        double total = 0;
        for (GroceryItem item : items) {
            total += item.getTotalPrice();
        }
        return total;
    }

    public void printReceipt() {
        System.out.println("\n====================================");
        System.out.println("      GROCERY STORE RECEIPT");
        System.out.println("====================================");
        System.out.printf("%-15s %-8s %-8s %-10s%n",
                "Item", "Price", "Qty", "Total");

        for (GroceryItem item : items) {
            System.out.printf("%-15s %-8.2f %-8d %-10.2f%n",
                    item.getName(),
                    item.getPrice(),
                    item.getQuantity(),
                    item.getTotalPrice());
        }

        double subtotal = calculateTotal();
        double tax = subtotal * 0.05; // 5% tax
        double finalAmount = subtotal + tax;

        System.out.println("------------------------------------");
        System.out.printf("Subtotal : %.2f%n", subtotal);
        System.out.printf("Tax (5%%) : %.2f%n", tax);
        System.out.printf("Total    : %.2f%n", finalAmount);
        System.out.println("====================================");
        System.out.println("Thank You! Visit Again.");
    }
}

public class GroceryBill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bill bill = new Bill();

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= n; i++) {
            System.out.println("\nItem " + i);

            System.out.print("Enter item name: ");
            String name = sc.nextLine();

            System.out.print("Enter price: ");
            double price = sc.nextDouble();

            System.out.print("Enter quantity: ");
            int quantity = sc.nextInt();
            sc.nextLine();

            GroceryItem item = new GroceryItem(name, price, quantity);
            bill.addItem(item);
        }

        bill.printReceipt();

        sc.close();
    }
}