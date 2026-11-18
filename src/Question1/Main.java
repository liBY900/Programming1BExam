package Question1;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // array for product names
        String[] products = {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"};

        // Two-dimensional array for sales
        int[][] sales = new int[3][3];

        for (int product = 0; product < products.length; product++) {
            for (int pro = 0; pro < 3; pro++) {
                System.out.print("Enter number of sales for month " + (pro + 1) + " for " + products[product] + " mattress: ");
                sales[product][pro] = scanner.nextInt();
            }
            System.out.println();
        }

        //  display report
        Product productObj = new Product(products, sales);
        PrintProduct printer = new PrintProduct(productObj);
        printer.printReport();


    }
}