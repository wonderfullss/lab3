package libraries;

import Expection.BookIndexOutOfBoundsException;
import Expection.HallIndexOutOfBoundsException;
import Interface.ILibrary;

import java.util.Arrays;

public class ChildrenLibrary implements ILibrary, Cloneable {
    ChildrenLibraryHall[] arrayHall;

    public ChildrenLibrary(ChildrenLibraryHall[] arrayHall) {
        this.arrayHall = arrayHall;
    }

    public ChildrenLibrary(int countHalls, int[] countBooksInHalls) {
        this.arrayHall = new ChildrenLibraryHall[countHalls];
        for (int i = 0; i < countHalls; i++) {
            arrayHall[i] = new ChildrenLibraryHall("0", countBooksInHalls[i]);
        }
    }

    @Override
    public Object clone() {
        return null;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(arrayHall);
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) return true;
        else if (object == null || object.getClass() != getClass()) return false;
        else {
            ChildrenLibrary book = (ChildrenLibrary) object;
            return Arrays.equals(book.getArrayHall(), arrayHall);
        }
    }

    @Override
    public String toString() {
        return "ChildrenLibrary{" + "arrayHall=" + Arrays.toString(arrayHall) + '}';
    }

    // колличество залов в библиотеке
    public int getCountHall() {
        return arrayHall.length;
    }

    // колличество книг в библиотеке
    public int getCountBook() {
        int counter = 0;
        for (int i = 0; i < arrayHall.length; i++) {
            counter += arrayHall[i].getCountBook();
        }
        return counter;
    }

    // сумма цены всех книг в библиотеке
    public int countPrice() {
        int counter = 0;
        for (int i = 0; i < arrayHall.length; i++) {
            counter += arrayHall[i].countPrice();
        }
        return counter;
    }

    // возвращение зала по его номеру в библиотеке
    public ChildrenLibraryHall returnHall(int number) {
        if (number < 0 || number > arrayHall.length) throw new HallIndexOutOfBoundsException("Неправильный номер зала");
        else return arrayHall[number];
    }

    // возвращение книги по ее номеру
    public ChildrenBook returnBook(int numberBook) throws BookIndexOutOfBoundsException {
        if (numberBook > getCountBook() || numberBook < 0)
            throw new BookIndexOutOfBoundsException(numberBook, "Неправильный индекс книги");
        else {
            int tempCount = 0;
            for (int i = 0; i < arrayHall.length; i++)
                for (int j = 0; j < arrayHall[i].getArray().length; j++) {
                    if (numberBook == tempCount) return arrayHall[i].getArray()[j];
                    else tempCount++;
                }
        }
        return null;
    }

    // печать названия залов и колличество книг в них
    public void printHall() {
        for (ChildrenLibraryHall childrenLibraryHall : arrayHall) {
            System.out.println(childrenLibraryHall.getChildrenHallName() + " " + childrenLibraryHall.getCountBook());
        }
    }

    // замена зала по индексу
    public void changeHall(int number, ChildrenLibraryHall other) {
        if (number < 0 || number > getCountHall()) throw new HallIndexOutOfBoundsException("Не правильный номер зала");
        else {
            int tempCount = 0;
            for (int i = 0; i < arrayHall.length; i++)
                for (int j = 0; j < arrayHall[i].getArray().length; j++) {
                    if (number == tempCount) this.arrayHall[i] = other;
                    else tempCount++;
                }
        }
    }

    // замена книги на другую по ее индексу
    public void changeBook(ChildrenBook other, int numberBook) throws BookIndexOutOfBoundsException {
        if (numberBook < 0 || numberBook > getCountBook()) {
            throw new BookIndexOutOfBoundsException(numberBook, "Error");
        } else {
            int tempCount = 0;
            for (int i = 0; i < arrayHall.length; i++)
                for (int j = 0; j < arrayHall[i].getArray().length; j++) {
                    if (numberBook == tempCount) arrayHall[i].getArray()[j] = other;
                    else tempCount++;
                }
        }
    }

    // добавление книги по заданному индексу
    public void addBook(ChildrenBook other, int numberBook) throws BookIndexOutOfBoundsException {
        if (numberBook < 0 || numberBook > getCountBook()) {
            throw new BookIndexOutOfBoundsException(numberBook, "Error");
        } else {
            int tempCount = 0;
            for (int i = 0; i < arrayHall.length; i++)
                for (int j = 0; j < arrayHall[i].getArray().length; j++) {
                    if (numberBook == tempCount) {
                        arrayHall[i].addBook(other, j);
                        break;
                    } else {
                        tempCount++;
                    }
                }
        }
    }

    // удаление книги по заданному индексу
    public void delBook(int numberBook) throws BookIndexOutOfBoundsException {
        if (numberBook < 0 || numberBook > getCountBook()) {
            throw new BookIndexOutOfBoundsException(numberBook, "Неправильный индекс книги");
        } else {
            int tempCount = 0;
            for (int i = 0; i < arrayHall.length; i++)
                for (int j = 0; j < arrayHall[i].getArray().length; j++) {
                    if (numberBook == tempCount) {
                        arrayHall[i].delBook(j);
                    } else {
                        tempCount++;
                    }
                }
        }
    }

    // поиск книги с самой большой ценой среди всех залов
    public ChildrenBook getBestBook() {
        int tempI = 0;
        int tempJ = 0;
        double max = 0;
        for (int i = 0; i < arrayHall.length; i++) {
            for (int j = 0; j < arrayHall[i].getArray().length; j++) {
                if (arrayHall[i].getArray()[j].getPrice() > max) {
                    max = arrayHall[i].getArray()[j].getPrice();
                    tempI = i;
                    tempJ = j;
                }
            }
        }
        return arrayHall[tempI].getArray()[tempJ];
    }

    // сортировка по убыванию цены
    public void sortByPrice() {
        for (int i = 0; i < arrayHall.length; i++) {
            for (int j = arrayHall[i].getArray().length - 1; j >= 0; j--) {
                for (int c = arrayHall[i].getArray().length - 1; c >= 1; c--) {
                    if (arrayHall[i].getArray()[c].getPrice() > arrayHall[i].getArray()[c - 1].getPrice()) {
                        ChildrenBook temp = arrayHall[i].getArray()[c];
                        arrayHall[i].getArray()[c] = arrayHall[i].getArray()[c - 1];
                        arrayHall[i].getArray()[c - 1] = temp;
                    }
                }
            }
        }
    }

    public ChildrenLibraryHall[] getArrayHall() {
        return arrayHall;
    }

    public void setArrayHall(ChildrenLibraryHall[] arrayHall) {
        this.arrayHall = arrayHall;
    }
}