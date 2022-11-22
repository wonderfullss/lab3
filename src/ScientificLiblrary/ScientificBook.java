package ScientificLiblrary;

import Interface.IBook;
import libraries.Book;

import java.util.Objects;

public class ScientificBook extends Book implements IBook, Cloneable {
    private ScientificBook next;
    private double citation;

    public ScientificBook() {
        next = null;
    }

    public ScientificBook(String authorS, int year) {
        super(authorS, year);
        this.citation = 0;
        next = null;
    }

    @Override
    public String toString() {
        return getName() + " " + getYear() + " " + getAuthor() + " " + getPrice() + " " + getCitation();
    }

    @Override
    public boolean equals(Object object) {
        if (object == this)
            return true;
        else if (object == null || object.getClass() != getClass())
            return false;
        else {
            ScientificBook book = (ScientificBook) object;
            return book.citation == citation && book.getPrice() == getPrice() && book.getAuthor().equals(getAuthor()) && book.getName().equals(getName()) && book.getYear() == getYear();
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), citation);
    }

    @Override
    public ScientificBook clone() {
        ScientificBook book = null;
        try {
            book = (ScientificBook) super.clone();
        } catch (CloneNotSupportedException ex) {

        }
        return book;
    }

    public ScientificBook(String bookN, String authorS, double price, int year, double citation) {
        super(bookN, authorS, price, year);
        this.citation = citation;
        next = null;
    }

    public ScientificBook getNext() {
        return next;
    }

    public void setNext(ScientificBook next) {
        this.next = next;
    }

    public double getCitation() {
        return citation;
    }

    public void setCitation(double citation) {
        this.citation = citation;
    }
}