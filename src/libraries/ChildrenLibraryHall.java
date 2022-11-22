package libraries;

import Expection.BookIndexOutOfBoundsException;
import Expection.InvalidBookPriceException;
import Interface.IHall;

import java.util.Arrays;
import java.util.Objects;

public class ChildrenLibraryHall implements IHall, Cloneable {
    private String childrenHallName;
    private ChildrenBook[] array;

    public ChildrenLibraryHall(String childrenHallName, int countBooks) {
        this.childrenHallName = childrenHallName;
        this.array = new ChildrenBook[countBooks];
        for (int i = 0; i < countBooks; i++) {
            array[i] = new ChildrenBook();
        }
    }

    public ChildrenLibraryHall(String childrenHallName, ChildrenBook[] array) {
        this.childrenHallName = childrenHallName;
        this.array = array;
    }

    // ����������� ����
    public int getCountBook() {
        return array.length;
    }

    // ���������� �������� ���� ����
    public void printBooks() {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i].getName());
        }
    }

    // ����� ���� ���� ����
    public int countPrice() {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            count += array[i].getPrice();
        }
        if (count < 0)
            throw new InvalidBookPriceException("������������ ���� �����    ");
        else
            return count;
    }

    // ����������� ����� �� ������
    public ChildrenBook returnBook(int number) throws BookIndexOutOfBoundsException {
        if (number > array.length || number < 0) {
            throw new BookIndexOutOfBoundsException(number, "������������ ������ �����");
        } else
            return array[number];
    }

    // ������ ����� �� ������
    public void changeBook(ChildrenBook book, int number) throws BookIndexOutOfBoundsException {
        if (number < 0 || number > array.length)
            throw new BookIndexOutOfBoundsException(number, "������������ ������ �����");
        else
            this.array[number] = book;
    }

    // �������� ����� �� ������
    public void delBook(int number) throws BookIndexOutOfBoundsException {
        if (number < 0 || number > array.length)
            throw new BookIndexOutOfBoundsException(number, "������������ ������ �����");
        else {
            ChildrenBook temp = array[number];
            array[number] = array[array.length - 1];
            array[array.length - 1] = temp;
            ChildrenBook[] del = Arrays.copyOf(array, array.length - 1);
            this.array = del;
        }
    }

    @Override
    public String toString() {
        return "ChildrenLibraryHall{" +
                " childrenHallName='" + childrenHallName + '\'' +
                ", array=" + Arrays.toString(array) +
                '}';
    }

    @Override
    public Object clone() {
        return null;
    }

    // ���������� ����� �� ������
    public void addBook(ChildrenBook book, int number) {
        ChildrenBook[] add = Arrays.copyOf(array, array.length + 1);
        for (int i = add.length - 1; i > number; i--) {
            add[i] = add[i - 1];
        }
        add[number] = book;
        this.array = add;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this)
            return true;
        else if (object == null || object.getClass() != getClass())
            return false;
        else {
            ChildrenLibraryHall book = (ChildrenLibraryHall) object;
            return book.getChildrenHallName().equals(childrenHallName) && Arrays.equals(book.getArray(), array);
        }
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(childrenHallName);
        result = 31 * result + Arrays.hashCode(array);
        return result;
    }

    // ����� � ����� ������� �����
    public ChildrenBook getBestBook() {
        double max = array[0].getPrice();
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i].getPrice() > max) {
                max = array[i].getPrice();
                index = i;
            }
        }
        return array[index];
    }
    public String getChildrenHallName() {
        return childrenHallName;
    }

    public void setChildrenHallName(String childrenHallName) {
        this.childrenHallName = childrenHallName;
    }

    public ChildrenBook[] getArray() {
        return array;
    }

    public void setArray(ChildrenBook[] array) {
        this.array = array;
    }

}
