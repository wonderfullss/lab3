package libraries;

public interface IHall {
    public void printBooks();

    public int getCountBook();

    public int countPrice();

    public ChildrenBook returnBook(int index);

    public void addBook(ChildrenBook book, int number);

    public void delBook(int number);

    public void changeBook(ChildrenBook book, int number);
}
