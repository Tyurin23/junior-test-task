package ru.buyanov.hunting;

import java.util.Iterator;

/**
 *  @author https://github.com/alex-on-java 03.02.2016
 */
public class IntIterable implements Iterable<Integer> {
    int[] backed;
    int index;

    public IntIterable(int[] backed) {
        this.backed = backed;
        this.index = 0;
    }

    public Iterator<Integer> iterator() {
        return new IntIterator();
    }

    private class IntIterator implements Iterator<Integer> {

        public boolean hasNext() {
            //TODO: You task is implement this method
            if (backed == null) throw new NullPointerException();
            if (backed.length == 0) return false;
            return index < backed.length;
        }

        public Integer next() {
            //TODO: You task is implement this method
            if (backed == null) throw new  NullPointerException();
            if (backed.length == 0) return null;
            return backed[index++];
        }

        public void remove() {
            throw new IllegalStateException("Could not remove from array");
        }
    }
}
