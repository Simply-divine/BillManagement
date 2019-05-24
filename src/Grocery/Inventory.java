package Grocery;

import java.util.Arrays;
import java.util.Scanner;

public class Inventory extends Product {
    private static int inventoryProductCounter = 4;

    //    public Product[] getP() {
//        return p;
//    }
    //product array to call multiple products
    Product[] p;
    String yourChoice;
    Scanner scanner = new Scanner(System.in);
    String s;

    //constructor call
    Inventory() {
        p = new Product[4];
        p[0] = new Product("mango", 1, 23, 1);
        p[1] = new Product("banana", 2, 3, 20);
        p[2] = new Product("orange", 3, 7, 30);
        p[3] = new Product("guava", 4, 10, 12);


    }

    public static int getInventoryProductCounter() {
        return inventoryProductCounter;
    }

    //optional..for testing purpose
    public static void main(String[] args) {
        Inventory i = new Inventory();
        Product p1 = new Product("pant", 5, 12, 100);
        i.showItemsOfInventory();
//        i.updateItems();
//        for (int j = 0; j <i.inventoryProductCounter ; j++) {
//            i.p[j].displayProduct();
//        }
        i.addItemsToInventory(p1);
        i.showItemsOfInventory();
    }

    void updateItems() {
        do {
            System.out.println("enter the id of item to be updated else enter \"stop\"");
            scanner.reset();
            yourChoice = scanner.next();
            if (!yourChoice.equalsIgnoreCase("stop")) {
                for (int i = 0; i < inventoryProductCounter; i++) {
                    if (p[i].getProductId() == Integer.parseInt(yourChoice)) {
                        System.out.println("enter the name of new product:");
                        scanner.reset();
                        yourChoice = scanner.next();
                        if (!yourChoice.equalsIgnoreCase("stop")) {
                            p[i].setProductName(yourChoice);
                        } else break;
                        System.out.println("enter the product quantity in inventory");
                        yourChoice = scanner.next();
                        if (!yourChoice.equalsIgnoreCase("stop")) {
                            p[i].setProductQuantity(Integer.parseInt(yourChoice));
                        } else break;
                        System.out.println("enter the product price in inventory");
                        yourChoice = scanner.next();
                        if (!yourChoice.equalsIgnoreCase("stop")) {
                            p[i].setProductPrice(Integer.parseInt(yourChoice));
                        } else break;


                    }
                }
            }


        } while (!yourChoice.matches("stop"));
    }

    //    methods to add an itm to inventory or any other methods specific to inventory
    void addItemsToInventory(Product product) {
        p = Arrays.copyOf(p, inventoryProductCounter + 1);
        p[inventoryProductCounter] = new Product(product.getProductName(), product.getProductId(), product.getProductQuantity(), product.getProductPrice());
        inventoryProductCounter++;
    }

    void showItemsOfInventory() {
        for (int j = 0; j < inventoryProductCounter; j++) {
            this.p[j].displayProduct();
            System.out.println("---------------------------------------------------------------------------");
        }
    }
}