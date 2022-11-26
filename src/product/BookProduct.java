package product;

public class BookProduct extends ShopProduct {

    int pages;

    public BookProduct(
            String title,
            String firstName,
            String lastName,
            int year,
            int price,
            int pages

    ){
        super(
                title,
                firstName,
                lastName,
                year,
                price
        );
        this.pages = pages;
    }

    public String getSummaryLine()
    {
        String base  = super.getSummaryLine();
        base += ": ";
        base += this.pages + " Seiten";
        return base;
    }

    public int getPages() {
        return this.pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

}
