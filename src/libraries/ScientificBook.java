package libraries;

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

    public ScientificBook(String bookN, String authorS, double price, int year, double citation) {
        super(bookN, authorS, price, year);
        this.citation = citation;
        next = null;
    }

    public ScientificBook clone() {
        ScientificBook copy = null;
        try {
            copy = (ScientificBook) super.clone();
        } catch (CloneNotSupportedException ex) {

        }
        return copy;
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