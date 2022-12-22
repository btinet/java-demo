package product;


import java.util.Objects;

abstract class ShopProduct {

    protected String title;
    protected String authorName = null;
    protected String firstName;
    protected String lastName;
    int year;

    int price = 0;

    public ShopProduct(
            String title,
            String firstName,
            String lastName,
            int year,
            int price
    ){
     this.title = title;
     this.firstName = firstName;
     this.lastName = lastName;
     this.price = price;
    }

    public String getSummaryLine()
    {
        String base  = "";
        base += title;
        base += " (";
        base += Objects.requireNonNullElseGet(authorName, () -> firstName + " " + lastName);
        base += ") ";
        return base;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
