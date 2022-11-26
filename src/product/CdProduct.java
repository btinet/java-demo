package product;

public class CdProduct extends ShopProduct {

    int playLength;

    public CdProduct(
            String title,
            String firstName,
            String lastName,
            int year,
            int price,
            int playLength

    ){
        super(
                title,
                firstName,
                lastName,
                year,
                price
        );
        this.playLength = playLength;
    }

    public String getSummaryLine()
    {
        String base  = super.getSummaryLine();
        base += ": ";
        base += this.playLength + " Minuten";
        return base;
    }

    public int getPlayLength() {
        return playLength;
    }

    public void setPlayLength(int playLength) {
        this.playLength = playLength;
    }

}
