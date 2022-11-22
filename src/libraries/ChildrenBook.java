package libraries;

import Interface.IBook;

import java.util.Objects;

public class ChildrenBook extends Book implements Cloneable, IBook {
    private int minAge;

    public ChildrenBook(String name, String author, double price, int year, int minAge) {
        super(author, name, price, year);
        this.minAge = minAge;
    }

    public ChildrenBook() {
        super();
        this.minAge = 0;
    }

    public ChildrenBook(String author, int year, int minAge) {
        super(author, year);
        this.minAge = minAge;
    }

    @Override
    public String toString() {
        return "ChildrenBook " + "{author='" + getAuthor() + '\'' + ", name='" + getName() + '\'' + ", year='" + getYear() + '\'' + ", price='" + getPrice() + '\'' + " minAge='" + minAge + '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), minAge);
    }


    @Override
    public ChildrenBook clone() throws CloneNotSupportedException {
        ChildrenBook clone = (ChildrenBook) super.clone();
        return clone;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) return true;
        else if (object == null || object.getClass() != getClass()) return false;
        else {
            ChildrenBook book = (ChildrenBook) object;
            return book.getName().equals(getName()) && book.getPrice() == getPrice() && book.getAuthor().equals(getAuthor()) && book.getYear() == getYear() && book.getMinAge() == minAge;
        }
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }

    public int getMinAge() {
        return minAge;
    }
}
