package ScientificLiblrary;

import Expection.BookIndexOutOfBoundsException;
import Expection.HallIndexOutOfBoundsException;
import Expection.InvalidBookCountException;
import Expection.InvalidBookPriceException;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ScientificBook book1 = new ScientificBook("Capital", "Karl Marks", 700, 1867, 0.4);
        ScientificBook book2 = new ScientificBook("The Mathematical Experience", "Reuben Hersh", 600, 2002, 0.2);
        ScientificBook book3 = new ScientificBook("Origin of species", "Charles Darwin", 950, 2003, 0.3);
        ScientificBook book4 = new ScientificBook("Computer science", "Rafgarden", 3300, 2010, 0.8);
        ScientificBook[] array = {book1, book2, book3, book4};
        ScientificLibraryHall hall1 = new ScientificLibraryHall("hall1", array);
        ScientificLibraryHall hall2 = new ScientificLibraryHall("hall2", array);
        ScientificLibraryHall hall3 = new ScientificLibraryHall("hall3", array);
        ScientificLibraryHall hall4 = new ScientificLibraryHall("hall4", array);
        ScientificLibraryHall hall5 = hall1.clone();
        ScientificBook book5 = book1.clone();
        System.out.println(book5);
        System.out.println(hall5);
        ScientificLibraryHall[] arrayHall = {hall1, hall2, hall3, hall4};
        ScientificLibrary lib = new ScientificLibrary(arrayHall);
        try {
            System.out.println(book1.hashCode());
            System.out.println(book2.hashCode());
            System.out.println(book3.hashCode());
            System.out.println(hall1.hashCode());
            System.out.println(hall2.hashCode());
            lib.print();
            System.out.println("add Book");
            lib.addBook(0, book4);
            lib.print();
            System.out.println(lib);
            System.out.println(Arrays.toString(arrayHall));
            System.out.println(hall1);
            System.out.println("remove book");
            lib.deleteBook(3135);
            lib.print();
            System.out.println("change book");
            System.out.println(2 + " " + lib.getBook(2).getAuthor());
            lib.changeBook(2, book4);
            System.out.println(2 + " " + lib.getBook(2).getAuthor());
            System.out.println("");
            lib.changeHall(0, hall3);
            lib.print();
            System.out.println("best book " + lib.getBestBoook().getPrice());
            System.out.println("sort");
            System.out.println(Arrays.toString(lib.sortedArr()));
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
