package application;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner tc = new Scanner(System.in);

        List<Product> list = new ArrayList<>();
        int createProducts;

        System.out.println("Enter the number of products: ");
        createProducts = tc.nextInt();

        for (int i = 0; i < createProducts; i++) {
            System.out.println("Product #" + (i + 1) +" data:");
            System.out.println("Common, used or imported (c/u/i) ?");
            String decision = tc.next();
            System.out.println("Name: ");
            String name = tc.next();
            System.out.println("Price: ");
            double price = tc.nextDouble();
            if (decision.equalsIgnoreCase("i")) {
                System.out.println("Customs fee: ");
                double customsFee = tc.nextDouble();
                Product product = new ImportedProduct(name, price, customsFee);
                list.add(product);
            }
            else if (decision.equalsIgnoreCase("u")) {
                System.out.println("Manufacture Date (DD/MM/YYYY) : ");
                String dateStr = tc.next();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    Date date = sdf.parse(dateStr);
                    Product product = new UsedProduct(name, price, date);
                    list.add(product);
                } catch (ParseException e) {
                    System.out.println("Invalid date format. Please use DD/MM/YYYY.");
                }
            } else {
                Product product = new Product(name, price);
                list.add(product);
            }
        }
        for (int i = 0; i < list.size(); i++){
            System.out.println(list.get(i).priceTag());
        }
    }
}
