package Grocery;

import java.util.Arrays;
import java.util.Scanner;

public class Merchant extends Inventory {
    Customer[] customer = new Customer[1];
    Inventory inventory;
    int customerCount = 1;
    Scanner scanner = new Scanner(System.in);
    String name;
    int id,price,quantity;
    int selection;
    String customerSelected;

    Merchant() {
        do {
            System.out.println("select an operation to perform: select number\n" +
                    "1. add an item to bill\n" +
                    "2.update an item in inventory\n" +
                    "3.add an item in inventory\n" +
                    "4.search all customers\n" +
                    "5.search a pearticular customers\n" +
                    "6.stop");
            selection = scanner.nextInt();

            switch (selection) {
                case 1:
                    customer[customerCount - 1] = new Customer();
                    customer[customerCount - 1].AddBillofCustomer();
                    customer = Arrays.copyOf(customer, customerCount + 1);
                    customerCount++;
                    //customer[customerCount-1].displayProduct();
                    break;
                case 2:
                    inventory.updateItems();
                    break;
                case 3:
                    System.out.println("enter the name of product,id quantity and price");
                    name=scanner.next();
                    id=scanner.nextInt();
                    price=scanner.nextInt();
                    quantity=scanner.nextInt();
                    Product p=new Product(name,id,quantity,price);
                    inventory.addItemsToInventory(p);
                    break;
                case 4:
                    try {
                        for (int i = 0; i < customerCount; i++) {
                            customer[i].customeDisplay();
                        }
                    }catch (Exception e){};

                case 5:
                    System.out.println("enter the name of customer to be searched");
                    customerSelected=scanner.next();
                    try {
                        for (int i = 0; i < customerCount; i++) {
                            if (customer[i].customerName.equalsIgnoreCase(customerSelected)) {
                                customer[i].customeDisplay();
                            }
                        }
                    }catch (Exception e){}


            }

        } while (selection != 6);
    }

    public static void main(String[] args) {
        Merchant merchant = new Merchant();
    }

}
