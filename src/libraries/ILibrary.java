package libraries;

public interface ILibrary {
    public int getCountHall();

    public void sortByPrice();

   // public ChildrenBook getBestBook();

    public void changeHall(int number, ChildrenLibraryHall other);

    public void printHall();

    public ChildrenLibraryHall returnHall(int number);
}
