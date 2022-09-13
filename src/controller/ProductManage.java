package controller;

import model.Product;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class ProductManage {
   public static ArrayList<Product> products = new ArrayList<>();

    public Product creatProduct(Scanner scanner) {
        System.out.println("Enter the id product: ");
        String productCode = scanner.nextLine();
        System.out.println("Enter the name product: ");
        String productName = scanner.nextLine();
        System.out.println("Enter the price product: ");
        int productPrice = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter the amount product: ");
        int productAmount = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter the description product: ");
        String productDescription = scanner.nextLine();
        return new Product(productCode, productName, productPrice, productAmount, productDescription);
    }

    public void addProduct(Scanner scanner) {
        Product product = creatProduct(scanner);
        products.add(product);
    }

    public void displayProduct() {
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public void editProduct(Scanner scanner) {
        System.out.println("Enter the id of product want to edit: ");
        String code = scanner.nextLine();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductId().equals(code)) {
                System.out.println("Enter new id:  ");
                String productCode = scanner.nextLine();
                System.out.println("Enter the name: ");
                String productName = scanner.nextLine();
                System.out.println("Enter price: ");
                int productPrice = Integer.parseInt(scanner.nextLine());
                System.out.println("Enter amount: ");
                int productAmount = Integer.parseInt(scanner.nextLine());
                System.out.println("Enter description: ");
                String productDescription = scanner.nextLine();
                products.get(i).setProductId(productCode);
                products.get(i).setProductName(productName);
                products.get(i).setProductPrice(productPrice);
                products.get(i).setProductAmount(productAmount);
                products.get(i).setProductDescription(productDescription);
                System.out.println("Edited successfully!");
            } else {
                System.out.println("No products found! ");
            }
        }
    }

    public void productRemove(Scanner scanner) {
        boolean check = false;
        System.out.print("Enter id of product want to delete: ");
        String id = scanner.nextLine();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductId().equals(id)) {
                products.remove(i);
                System.out.println("Deleted successfully!");
                check = true;
            }
        }
        if (!check) {
            System.err.println("No products found! " + id);
        }
    }
    public void sortProductsByPriceAscending() {
        Comparator<Product> comparator = new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return (int) (o1.getProductPrice()) - o2.getProductPrice();
            }
        };
        products.sort(comparator);
        System.out.println("List of products sorted in ascending order: ");
        displayProduct();
    }
    public void sortProductByPriceDescending() {
        Comparator<Product> comparator = new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return (int) (o2.getProductPrice()) - o1.getProductPrice();
            }
        };
        products.sort(comparator);
        System.out.println("List of products sorted in descending order: ");
        displayProduct();
    }
    public void searchMaxPrice() {
        double max = 0;
        int product = 0;
        for (int i = 0; i < products.size(); i++) {
            if (max < products.get(i).getProductPrice()) {
                max = products.get(i).getProductPrice();
                product = i;
            }
        }
        System.out.println("Product has cost max is: ");
        System.out.println(products.get(product));
    }
}