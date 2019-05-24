package Grocery;

import java.util.Arrays;
import java.util.Scanner;

public class Bill extends Inventory {
    static int total = 0;
    //fields
    Product[] p = new Product[1];
    int productcounter = 1;
    Inventory inventory = new Inventory();
    String data;
    Scanner scanner = new Scanner(System.in);

    //constructor
    Bill() {

    }

    public static void main(String[] args) {
        Bill bill = new Bill();
        bill.AddBill();
        bill.displayBill();
    }

    //methods
    void AddBill() {
        do {
            System.out.println("select an item id from inventory: ");
            inventory.showItemsOfInventory();
            data = scanner.next();
            if (!data.matches("stop")) {
                for (int i = 0; i < Inventory.getInventoryProductCounter(); i++) {
                    if (inventory.p[i].getProductId() == Integer.parseInt(data)) {
                        System.out.println("enter the product quantity: ");
                        scanner.reset();
                        int x = scanner.nextInt();
                        if ((inventory.p[i].getProductQuantity() - x) >= 0)
                            inventory.p[i].setProductQuantity(inventory.p[i].getProductQuantity() - x);
                        else {
                            System.out.println("we have only " + inventory.p[i].getProductQuantity() + " products..do you want all of them..select yes or no");
                            scanner.reset();
                            String y = scanner.next();
                            if (y.equalsIgnoreCase("y")) {
                                x = inventory.p[i].getProductQuantity();
                                total += inventory.p[i].getProductPrice() * x;
                                inventory.p[i].setProductQuantity(0);
                            } else continue;
                        }
                        p[productcounter - 1] = new Product(inventory.p[i].getProductName(), inventory.p[i].getProductId(), x, inventory.p[i].getProductPrice());
                        total += inventory.p[i].getProductPrice() * x;
                        p = Arrays.copyOf(p, productcounter + 1);
                        productcounter++;
                        break;
                    }
                }
            }

        } while (!data.matches("stop"));
    }

    void displayBill() {
        System.out.println("your bill is here :");
        for (int i = 0; i < productcounter - 1; i++) {
            p[i].displayProduct();
        }
        System.out.println("your total is :$" + total);
    }

}