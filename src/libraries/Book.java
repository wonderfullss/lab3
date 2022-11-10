package libraries;

public class Book implements IBook {
    private String author, name;
    private int year;
    private double price;

    public Book(String author, String name, double price, int year) {
        this.author = author;
        this.name = name;
        this.price = price;
        this.year = year;
    }

    public Book() {
        this.author = "undefined";
        this.name = "undefined";
        this.price = 0.0;
        this.year = 0;
    }

    public Book(String author, int year) {
        this();
        this.author = author;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", price=" + price +
                '}';
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
