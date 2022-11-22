package ScientificLiblrary;

import Expection.BookIndexOutOfBoundsException;
import Expection.HallIndexOutOfBoundsException;
import Interface.ILibrary;
import libraries.ChildrenLibraryHall;

import java.util.Objects;

public class ScientificLibrary extends ScientificLibraryHall implements ILibrary {

    private int size;
    private int numOfBooks;
    private String name;
    private ScientificLibraryHall head;
    private ScientificLibraryHall tail;

    public ScientificLibrary(int size, int[] arr) {
        separ();
        this.size = size;
        if (size > 0) {
            cyrcle();
        }
        for (int i = 0; i < size; i++) {
            String name = "hall" + (i + 1);
            ScientificLibraryHall hall = new ScientificLibraryHall(name, arr[i]);
            numOfBooks += hall.getSize();
            add(hall);
        }

    }

    public ScientificLibrary(ScientificLibraryHall[] arr) {
        separ();
        this.size = arr.length;
        if (size > 0) {
            cyrcle();
        }
        for (int i = 0; i < size; i++) {
            String name = "hall" + i + 1;
            ScientificLibraryHall hall = arr[i].clone();
            numOfBooks += hall.getSize();
            add(hall);
        }
    }

    private boolean isEmpty() {
        return (head == null) || head.getNext() == tail;
    }

    private void cyrcle() {
        head.setNext(tail);
        head.setPrev(tail);
        tail.setNext(head);
        tail.setPrev(head);
    }

    private void uncyrcle() {
        head = null;
        tail = null;
    }

    private void add(ScientificLibraryHall hall) {
        hall.setPrev(tail.getPrev());
        hall.setNext(tail);
        tail.getPrev().setNext(hall);
        tail.setPrev(hall);
    }

    private void separ() {
        this.head = new ScientificLibraryHall();
        this.tail = new ScientificLibraryHall();
    }

    public double sumPrice() {
        if (isEmpty()) {
            System.out.println("List is Empty");
            return -1;
        }
        double sum = 0;
        ScientificLibraryHall p = head.getNext();
        do {
            sum += p.sumPrice();
            p = p.getNext();
        } while (p != tail);
        return sum;
    }

    public ScientificLibraryHall[] getLib() {
        if (isEmpty()) {
            System.out.println("List is empty");
        }
        ScientificLibraryHall[] lib = new ScientificLibraryHall[size];
        ScientificLibraryHall temp = head.getNext();
        for (int i = 0; i < size; i++) {
            lib[i] = temp;
            temp = temp.getNext();
        }
        return lib;
    }

    public ScientificLibraryHall getHall(int index) {
        if (isEmpty() || index >= size || index < 0) {
            throw new HallIndexOutOfBoundsException("Error");
        } else {
            ScientificLibraryHall temp = head.getNext();
            for (int i = 0; i < index + 1; i++) {
                temp = temp.getNext();
            }
            return temp;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), size, numOfBooks, name);
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) return true;
        else if (object == null || object.getClass() != getClass()) return false;
        else {
            ScientificLibrary book = (ScientificLibrary) object;
            return book.getCitation() == getCitation() && book.getPrice() == getPrice() && book.getAuthor().equals(getAuthor()) && book.getName().equals(getName()) && book.getYear() == getYear();
        }
    }

    private ScientificLibraryHall getTempByBookInd(int index) {
        ScientificLibraryHall temp = null;
        int counter = 0;
        ScientificLibraryHall tempHall = head.getNext();
        for (int i = 0; i < index + 1; i++) {
            ;
            if (counter + tempHall.getSize() > index) {
                temp = tempHall;
                break;
            } else {
                counter += tempHall.getSize();
                tempHall = tempHall.getNext();
            }
        }
        return temp;
    }

    private int getCounter(int index) {
        int counter = 0;
        ScientificLibraryHall tempHall = head.getNext();
        for (int i = 0; i < index + 1; i++) {
            ;
            if (counter + tempHall.getSize() > index) {
                break;
            } else {
                counter += tempHall.getSize();
                tempHall = tempHall.getNext();
            }
        }
        return counter;
    }

    public ScientificBook getBook(int index) {
        if (isEmpty() || index >= numOfBooks) {
            return null;
        }
        ScientificLibraryHall tempHall = getTempByBookInd(index);
        ScientificBook tempBook = null;
        tempBook = tempHall.getBook(index - getCounter(index));
        return tempBook;
    }

    public void changeHall(int index, ScientificLibraryHall hall) {
        if (isEmpty() || index >= size || index < 0) {
            throw new HallIndexOutOfBoundsException("Error");
        } else {
            ScientificLibraryHall temp = head;
            for (int i = 0; i < index + 1; i++) {
                temp = temp.getNext();
            }
            ScientificLibraryHall newHall = hall.clone();
            newHall.setNext(temp.getNext());
            newHall.setPrev(temp.getPrev());
            temp.getNext().setPrev(newHall);
            temp.getPrev().setNext(newHall);
        }
    }


    public void changeBook(int index, ScientificBook book) {
        if (isEmpty() || index >= numOfBooks || index < 0) {
            throw new BookIndexOutOfBoundsException(index, "Error");
        } else {
            ScientificLibraryHall temp = getTempByBookInd(index);
            temp.changeBook(index - getCounter(index), book);
        }
    }

    public void addBook(int index, ScientificBook book) {
        if (isEmpty() || index > numOfBooks) {
            throw new BookIndexOutOfBoundsException(index, "Error");
        } else {
            ScientificLibraryHall temp = getTempByBookInd(index);
            temp.addBook(index - getCounter(index), book);
            numOfBooks++;
        }
    }

    public void deleteBook(int index) {
        if (isEmpty() || index >= numOfBooks) {
            throw new BookIndexOutOfBoundsException(index, "Error");
        } else {
            ScientificLibraryHall temp = getTempByBookInd(index);
            temp.delBook(index - getCounter(index));
            numOfBooks--;
            if (numOfBooks == 0) {
                uncyrcle();
            }
        }
    }

    public ScientificBook getBestBoook() {
        if (isEmpty()) {
            return null;
        }
        ScientificLibraryHall temp = head.getNext();
        ScientificBook bestBook = temp.getBestBook();
        double max = temp.getBestBook().getPrice();
        while (temp != tail) {
            if (temp.getBestBook().getPrice() > max) {
                max = temp.getBestBook().getPrice();
                bestBook = temp.getBestBook();
            }
            temp = temp.getNext();
        }
        return bestBook;
    }

    public ScientificBook[] sortedArr() {
        if (isEmpty()) {
        }
        ScientificBook[] arr = new ScientificBook[numOfBooks];
        for (int i = 0; i < numOfBooks; i++) {
            arr[i] = getBook(i);
        }

        for (int out = numOfBooks - 1; out >= 1; out--) {
            for (int in = 0; in < out; in++) {
                if (arr[in].getPrice() < arr[in + 1].getPrice()) {
                    ScientificBook buff = arr[in];
                    arr[in] = arr[in + 1];
                    arr[in + 1] = buff;
                }
            }
        }
        return arr;
    }

    public boolean print() {
        if (isEmpty()) {
            return false;
        }
        ScientificLibraryHall temp = head.getNext();
        while (temp != tail) {
            System.out.println(temp.getName() + " " + temp.getSize());
            temp = temp.getNext();
        }
        return true;
    }

    public int getSize() {
        return size;
    }

    public int getNumOfBooks() {
        return numOfBooks;
    }

    @Override
    public int getCountHall() {
        return 0;
    }

    @Override
    public void sortByPrice() {

    }

    @Override
    public void changeHall(int number, ChildrenLibraryHall other) {

    }

    @Override
    public void printHall() {

    }

    @Override
    public ChildrenLibraryHall returnHall(int number) {
        return null;
    }
}
