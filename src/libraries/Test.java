package libraries;

import Expection.BookIndexOutOfBoundsException;
import Expection.HallIndexOutOfBoundsException;
import Expection.InvalidBookCountException;
import Expection.InvalidBookPriceException;

public class Test {
    public static void main(String[] args) throws CloneNotSupportedException, BookIndexOutOfBoundsException, HallIndexOutOfBoundsException, InvalidBookCountException, InvalidBookPriceException {
        ChildrenBook[] books = new ChildrenBook[3];
        books[0] = new ChildrenBook("Borodino", "Lermontov", 1200, 1812, 7);
        books[1] = new ChildrenBook("Onegin", "Pushkin", 1600, 1856, 12);
        books[2] = new ChildrenBook("War and Peace", "Tolstoy", 1400, 1867, 12);
        ChildrenBook[] books1 = new ChildrenBook[3];
        books1[0] = new ChildrenBook("1994", "Oruel", 2000, 1980, 16);
        books1[1] = new ChildrenBook("Azbuka", "Mefodiy", 1900, 102, 16);
        books1[2] = new ChildrenBook("Witcher", "Sapkovsky", 1300, 1970, 16);
        ChildrenBook[] books2 = new ChildrenBook[3];
        books2[0] = new ChildrenBook("Spider-man", "MARVEL", 500, 1980, 14);
        books2[1] = new ChildrenBook("Batman", "DC", 300, 1980, 14);
        books2[2] = new ChildrenBook("Woman-cat", "MARVEL", 1200, 1980, 14);
        ChildrenLibraryHall[] Hall = new ChildrenLibraryHall[3];
        Hall[0] = new ChildrenLibraryHall("12+", books);
        Hall[1] = new ChildrenLibraryHall("16+", books1);
        Hall[2] = new ChildrenLibraryHall("14+", books2);
        ChildrenLibrary library = new ChildrenLibrary(Hall);
        try {
            ChildrenBook book = books[2].clone();
            ChildrenBook book1 = books[1].clone();
            System.out.println(book1.equals(books[1]));
            book.setYear(123);
            System.out.println(books[2].equals(book));
            ChildrenLibraryHall hallFree = Hall[0].clone();
            ChildrenLibraryHall hallFree1 = Hall[1].clone();
            hallFree.getArray()[0].setYear(1209);
            System.out.println(Hall[0].equals(hallFree));
            System.out.println(hallFree1.equals(Hall[1]));
            ChildrenLibrary libraryFree = library.clone();
            ChildrenLibrary libraryFree1 = library.clone();
            libraryFree.getArrayHall()[0].getArray()[0].setYear(213);
            System.out.println(libraryFree1.equals(library));
            System.out.println(library.equals(libraryFree));
            System.out.println(book);
            System.out.println(hallFree);
            System.out.println(libraryFree);
            System.out.println(books[2].hashCode());
            System.out.println(book.hashCode());
            System.out.println(books[1].hashCode());
            System.out.println(books[2].hashCode());
            System.out.println(books[0].equals(books[1]));
            System.out.println(Hall[0].hashCode());
            System.out.println(Hall[1].hashCode());
            System.out.println(Hall[2].hashCode());
        } catch (BookIndexOutOfBoundsException e) {
            System.out.println(e.getExpect());
        } catch (HallIndexOutOfBoundsException e) {
            System.out.println(e.getExpect());
        } catch (InvalidBookPriceException e) {
            System.out.println(e.getExpect());
        } catch (InvalidBookCountException e) {
            System.out.println(e.getExpect());
        }
    }
}
