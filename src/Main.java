import product.BookProduct;
import product.CdProduct;

public class Main {

    public static void main(String[] args)
    {
        BookProduct book1 = new BookProduct(
                "Weired Sisters",
                "Terry",
                "Prattchet",
                1989,
                995,
                495
        );

        CdProduct cd1 = new CdProduct(
                "Christmas Time",
                "Monkey",
                "Man",
                2017,
                1695,
                59
        );

        cd1.setAuthorName("Pentatonix");

        System.out.println(book1.getSummaryLine());
        System.out.println(cd1.getSummaryLine());
        System.out.println("Hello world!");
    }

}
