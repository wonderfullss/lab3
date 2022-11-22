package Interface;

import libraries.ChildrenBook;

public interface IHall {
    public void printBooks();

    public int getCountBook();

    public int countPrice();

    ChildrenBook returnBook(int index);

    public void addBook(ChildrenBook book, int number);

    public void delBook(int number);

    public void changeBook(ChildrenBook book, int number);

    public Object clone();
}
