package model;

import java.text.NumberFormat;
import java.util.Locale;

public class Product implements Comparable<Product> {
    private String productId;
    private String productName;
    private int productPrice;
    private int productAmount;
    private String productDescription;

    public Product(String productId, String productName, int productPrice, int productAmount, String productDescription) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productAmount = productAmount;
        this.productDescription = productDescription;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(int productAmount) {
        this.productAmount = productAmount;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    @Override
    public String toString() {
        Locale locale = new Locale("vi", "VN");
        NumberFormat numberFormat = NumberFormat.getInstance(locale);
        return "Product{" +
                "Id: '" + productId + '\'' +
                ", Name: '" + productName + '\'' +
                ", Price: " + numberFormat.format(productPrice) + "VND"+
                ", Amount: " + productAmount +
                ", Description: '" + productDescription + '\'' +
                '}';
    }

    @Override
    public int compareTo(Product a) {
        return this.getProductPrice() - a.getProductPrice();

    }
}