package views;

import controller.ProductManage;
import storage.ReadData;
import storage.WriteData;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductManage productManage = new ProductManage();
        int choice;
        do {
            System.out.println("---- PRODUCT MANAGEMENT PROGRAM ----");
            System.out.println("1. Display list");
            System.out.println("2. Add");
            System.out.println("3. Edit");
            System.out.println("4. Delete");
            System.out.println("5. Sort");
            System.out.println("6. Find product price max");
            System.out.println("7. Read from file csv");
            System.out.println("8. Write to file csv");
            System.out.println("9. Exit");
            System.out.println("--------------------------------------------------------");
            System.out.print("Select function: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1 -> productManage.displayProduct();
                case 2 -> productManage.addProduct(scanner);
                case 3 -> productManage.editProduct(scanner);
                case 4 -> productManage.productRemove(scanner);
                case 5 -> {
                    int choice1;
                    System.out.println("1. Sort up ascending");
                    System.out.println("2. sort descending");
                    choice1 = Integer.parseInt(scanner.nextLine());
                    switch (choice1) {
                        case 1 -> productManage.sortProductsByPriceAscending();
                        case 2 -> productManage.sortProductByPriceDescending();
                    }
                }
                case 6 -> productManage.searchMaxPrice();
                case 7 -> ReadData.readFileProductList();
                case 8 -> WriteData.writeFileProduct("FileProduct.csv");
                case 9 -> System.exit(0);
            }
        } while (true);
    }
}
