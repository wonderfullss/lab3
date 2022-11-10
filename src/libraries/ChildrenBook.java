package libraries;

public class ChildrenBook extends Book implements IBook {
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
        return "ChildrenBook " + "{author='" + getAuthor() + '\'' +
                ", name='" + getName() + '\'' +
                ", year='" + getYear() + '\'' +
                ", price='" + getPrice() + '\'' +
                " minAge='" + minAge +
                '}';
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }

    public int getMinAge() {
        return minAge;
    }
}
