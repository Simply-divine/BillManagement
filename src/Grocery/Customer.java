package Grocery;

import java.util.Arrays;
import java.util.Scanner;

public class Customer extends Bill {
    //customer fields
    String customerName;
    int customerId;
    String response;
    Bill[] bill = new Bill[1];
    Scanner scanner = new Scanner(System.in);
    int customerBillCount = 1;
    private int uniqueno = 10;

    // customer constructor
    Customer() {
        uniqueno++;
        customerId = (int) (uniqueno + System.currentTimeMillis());

        //various methods specific to a customer

    }

    public static void main(String[] args) {
        Customer c = new Customer();
        c.AddBillofCustomer();

    }

    void AddBillofCustomer() {
        System.out.println("enter customer name: ");
        this.customerName = scanner.next();
        do {
            bill[customerBillCount - 1] = new Bill();
            bill[customerBillCount - 1].AddBill();

            System.out.println("your bill id :" + this.customerId);
            bill[customerBillCount-1].displayBill();
            System.out.println("wanna make another bill? ");
            response = scanner.next();
            if (response.equalsIgnoreCase("yes")) {
                customerBillCount++;
                bill = Arrays.copyOf(bill, customerBillCount + 1);
                // bill[customerBillCount - 1] = new Bill();

            }

        } while (!response.equals("stop"));

    }
    void customeDisplay(){
        System.out.println("-------------------------------------------------------");
        System.out.println("customer name :"+customerName);
        System.out.println("customer id :"+customerId);
        for (int i = 0; i <customerBillCount ; i++) {
            bill[i].displayBill();
        }
        System.out.println("----------------------------------------------------");
    }

}