package ScientificLiblrary;

import Expection.BookIndexOutOfBoundsException;
import Interface.IHall;
import libraries.ChildrenBook;

import java.util.Arrays;
import java.util.Objects;

public class ScientificLibraryHall extends ScientificBook implements Cloneable, IHall {
    private int size = 0;
    private String name;
    private ScientificBook head;
    private ScientificLibraryHall prev;
    private ScientificLibraryHall next;

    public ScientificLibraryHall() {
        next = null;
        prev = null;
    }

    public ScientificLibraryHall(String name, int size) {
        this.name = name;
        this.size = size;
        next = null;
        prev = null;
        this.head = new ScientificBook();
        head.setNext(null);
        if (this.size > 0) {
            head.setNext(head);
        }
        for (int i = 0; i < size; i++) {
            ScientificBook temp = new ScientificBook();
            temp.setNext(head.getNext());
            head.setNext(temp);
        }
    }

    public ScientificLibraryHall(String name, ScientificBook[] array) {
        this.name = name;
        this.size = array.length;
        this.next = null;
        this.prev = null;
        this.head = new ScientificBook();
        this.head.setNext(null);
        if (this.size > 0) {
            head.setNext(head);
        }
        for (int i = 0; i < size; i++) {
            ScientificBook temp = (ScientificBook) array[i].clone();
            temp.setNext(head.getNext());
            head.setNext(temp);
        }
    }

    private boolean isEmpty() {
        return head.getNext() == null;
    }

    public void addBook(int index, ScientificBook book) {
        if (index <= size) {
            if (size == 0) {
                head.setNext(head);
            }
            ScientificBook item = head;
            for (int i = 0; i < index; i++) {
                item = item.getNext();
            }
            ScientificBook temp = (ScientificBook) book.clone();
            temp.setNext(item.getNext());
            item.setNext(temp);
            size++;
        } else {
            throw new BookIndexOutOfBoundsException(index, "Error");
        }
    }

    public void changeBook(int index, ScientificBook book) {
        if (!isEmpty() && index < size && index > -1) {
            ScientificBook item = head;
            for (int i = 0; i < index; i++) {
                item = item.getNext();
            }
            ScientificBook temp = book.clone();
            temp.setNext(item.getNext().getNext());
            item.setNext(temp);
        } else {
            throw new BookIndexOutOfBoundsException(index, "Error");
        }
    }

    public Object[] toArray() {
        Object[] values = new Object[this.size];
        int index = 0;
        for (ScientificBook node = this.head.getNext(); node != this.head; node = node.getNext()) {
            if (index == size)
                break;
            values[index] = node;
            index++;
        }
        return values;
    }

    @Override
    public String toString() {
        return Arrays.toString(this.toArray());
    }

    @Override
    public ScientificLibraryHall clone() {
        ScientificLibraryHall hall = (ScientificLibraryHall) super.clone();
        return hall;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this)
            return true;
        else if (object == null || object.getClass() != getClass())
            return false;
        else {
            ScientificLibraryHall book = (ScientificLibraryHall) object;
            return book.getCitation() == getCitation() && book.getPrice() == getPrice() && book.getAuthor().equals(getAuthor()) && book.getName().equals(getName()) && book.getYear() == getYear();
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), size, name);
    }

    public void delBook(int index) {
        if (isEmpty() || index >= size) {
            throw new BookIndexOutOfBoundsException(index, "Error");
        } else {
            ScientificBook item = head;
            for (int i = 0; i < index; i++) {
                item = item.getNext();
            }
            item.setNext(item.getNext().getNext());
            size--;
            if (size == 0) {
                head.setNext(null);
            }
        }
    }

    public void printBooks() {
        if (!isEmpty()) {
            ScientificBook temp = head.getNext();
            while (temp != head) {
                System.out.println(temp.getAuthor());
                temp = temp.getNext();
            }
        } else {
            throw new BookIndexOutOfBoundsException(0, "???? ???");
        }
    }

    public ScientificBook getBook(int index) {
        if (isEmpty() || index >= size) {
            return null;
        } else {
            ScientificBook temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.getNext();
            }
            return temp.getNext();
        }
    }

    public double sumPrice() {
        if (isEmpty()) {
            return -1;
        }
        double sum = 0;
        ScientificBook p = head.getNext();
        for (int i = 0; i < size; i++) {
            sum += p.getPrice();
            p = p.getNext();
        }
        return sum;
    }

    public ScientificBook getBestBook() {
        if (isEmpty()) {
            return null;
        }
        ScientificBook bestBook = head.getNext();
        ScientificBook temp = head.getNext();
        double max = temp.getPrice();
        while (temp != head) {
            if (temp.getPrice() > max) {
                max = temp.getPrice();
                bestBook = temp;
            }
            temp = temp.getNext();
        }
        return bestBook;
    }

    public ScientificLibraryHall getNext() {
        return next;
    }

    public void setNext(ScientificLibraryHall next) {
        this.next = next;
    }

    public ScientificLibraryHall getPrev() {
        return prev;
    }

    public void setPrev(ScientificLibraryHall prev) {
        this.prev = prev;
    }

    public int getSize() {
        return size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getCountBook() {
        return 0;
    }

    @Override
    public int countPrice() {
        return 0;
    }

    @Override
    public ChildrenBook returnBook(int index) {
        return null;
    }

    @Override
    public void addBook(ChildrenBook book, int number) {

    }

    @Override
    public void changeBook(ChildrenBook book, int number) {

    }
}
