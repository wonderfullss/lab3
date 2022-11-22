package libraries;

import Interface.IBook;

import java.util.Objects;

public class Book implements Cloneable, IBook {
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

    public Book clone() {
        Book book = new Book(author, name, price, year);
        return book;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this)
            return true;
        else if (object == null || object.getClass() != getClass())
            return false;
        else {
            Book book = (Book) object;
            return book.getName().equals(getName()) && book.getPrice() == getPrice() && book.getAuthor().equals(getAuthor()) && book.getYear() == getYear();
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, name);
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
