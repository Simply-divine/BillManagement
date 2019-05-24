package Grocery;

public class Product {
    // Product[] product;
    //product fields
    private String productName;
    private int productId;
    private int productQuantity;
    private int productPrice;

    public Product() {

    }

    public Product(String productName, int productId, int productQuantity, int productPrice) {
        this.productName = productName;
        this.productId = productId;
        this.productQuantity = productQuantity;
        this.productPrice = productPrice;
    }

    public static void main(String[] args) {
        Product p = new Product("mango", 1, 10, 10);
        p.displayProduct();
    }

    //getter and setter methods of product fields
    public String getProductName() {

        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public void displayProduct() {
        System.out.println("product id: " + this.productId);
        System.out.println("product name:" + this.productName);
        System.out.println("price of one product: $" + this.productPrice);
        System.out.println("product quantity: " + this.productQuantity);
    }


}
