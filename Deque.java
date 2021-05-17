import java.util.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.Collections;
import java.io.*;

public class Deque<E> {
    private ArrayList<E> deque;
    private int size;

    public Deque() {
        this.deque = new ArrayList<>();
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    //добавим последним
    public void addLast(E element) {
        this.deque.add(element);
        this.size++;
    }

    //добавим первым
    public void addFirst(E element) {
        this.deque.add(0, element);
        this.size++;
    }

    //вернем последний
    public E getLast() {
        if(size != 0) {
            return this.deque.get(this.size-1);
        }
        System.out.println("Deque is empty");
        return null;
    }

    //вернем первый
    public E getFirst() {
        if(size != 0) {
            return this.deque.get(0);
        }
        System.out.println("Deque is empty");
        return null;
    }

    //удалим последний
    public E removeLast() {
        if(size != 0) {
            E element = this.deque.get(this.size-1);
            this.deque.remove(this.size-1);
            this.size--;
            return element;
        }
        System.out.println("Deque is empty");
        return null;
    }

    //удалим первый
    public E removeFirst() {
        if(size != 0) {
            E element = this.deque.get(0);
            this.deque.remove(0);
            this.size--;
            return element;
        }
        System.out.println("Deque is empty");
        return null;
    }

    public String toString() {
        return Arrays.toString(this.deque.toArray());
    }

    public int getSize() {
        return this.size;
    }
}
