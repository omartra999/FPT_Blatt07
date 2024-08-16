package Aufgabe02;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;

//make sure that the class and the entery implement/extend Serializable
public class SimpleLinkedList<E extends Serializable> implements Iterable<E>, Serializable {
    private static final long serialVersionUID = 1L;
    private Entry head, tail;
    private int size;

    public SimpleLinkedList() {

    }

    public void prepend(E data) {
        head = new Entry(null, data, head);
        if (head.next != null) {
            head.next.previous = head;
        }
        if (tail == null) {
            tail = head;
        }
        size++;
    }

    public void append(E data) {
        tail = new Entry(tail, data, null);
        if (tail.previous != null) {
            tail.previous.next = tail;
        }
        if (head == null) {
            head = tail;
        }
        size++;
    }

    public E getFirst() {
        return head.data;
    }

    public E getLast() {
        return tail.data;
    }

    public E getAndRemoveFirst() {
        if (head == null) {
            throw new IllegalStateException();
        }
        E item = head.data;
        if (head.next == null) {
            tail = null;
        } else {
            head.next.previous = null;
        }
        head = head.next;
        size--;
        return item;
    }

    public E getAndRemoveLast() {
        if (tail == null) {
            throw new IllegalStateException();
        }
        E item = tail.data;
        if (tail.previous == null) {
            head = null;
        } else {
            tail.previous.next = null;
        }
        tail = tail.previous;
        size--;
        return item;
    }

    public int getSize() {
        return size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof SimpleLinkedList<?>)) {
            return false;
        }

        SimpleLinkedList<?> that = (SimpleLinkedList<?>) o;

        if (size != that.size) {
            return false;
        }

        Iterator<E> iter;
        Iterator<?> otherIter;
        iter = iterator();
        otherIter = that.iterator();

        while (iter.hasNext() && otherIter.hasNext()) {
            if (!iter.next().equals(otherIter.next())) {
                return false;
            }
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = size;
        for (E element : this) {
            result = 31 * result + element.hashCode();
        }
        return result;
    }

    //add read and write methods

    private void writeObject(ObjectOutputStream oos) throws IOException{
        oos.defaultWriteObject();
        oos.writeInt(size);
        for (E elemnt: this){
            oos.writeObject(elemnt);
        }
    }

    private void readObject(ObjectInputStream ois) throws IOException,ClassNotFoundException{
        ois.defaultReadObject();
        int size = ois.readInt();
        for(int i = 0; i < size ; i++){
            @SuppressWarnings("unchecked")
            E element = (E) ois.readObject();
            append(element);
        }

    }

    //implements Serializable
    private class Entry implements Serializable{
        E data;
        Entry previous, next;

        Entry(Entry previous, E data, Entry next) {
            this.previous = previous;
            this.data = data;
            this.next = next;
        }
    }

    public Iterator<E> iterator() {
        return new Iter();
    }

    private class Iter implements Iterator<E> {

        public Iter() {

        }

        private Entry next = head;

        @Override
        public boolean hasNext() {
            return next != null;
        }

        @Override
        public E next() {
            if (next == null) {
                throw new NoSuchElementException();
            }
            E data = next.data;
            next = next.next;
            return data;
        }
    }
}
