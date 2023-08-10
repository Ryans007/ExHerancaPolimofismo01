import Entities.ImportedProduct;
import Entities.Product;
import Entities.UsedProduct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of products: ");
        int n = sc.nextInt();

        List<Product> list = new ArrayList<>();

        for(int i = 1; i <=n; i++){
            System.out.println("Product #" + i + " data");
            System.out.print("Common, used or imported (c/u/i)? ");
            char state = sc.next().charAt(0);
            sc.nextLine();

            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Price: ");
            double price = sc.nextDouble();

            switch (state){
                case 'c':
                   list.add(new Product(name,price));
                   break;
                case 'u':
                    System.out.print("Manufacture date (DD/MM/YYYY): ");
                    Date date = sd.parse(sc.next());
                    list.add(new UsedProduct(name,price,date));
                    break;
                default:
                    System.out.print("Customs fee: ");
                    double fee = sc.nextDouble();
                    list.add(new ImportedProduct(name,price,fee));
                    break;
            }
        }
        System.out.println();
        System.out.println("PRICE TAGS: ");

        for (Product p : list) System.out.println(p.priceTag());

        sc.close();
    }
}