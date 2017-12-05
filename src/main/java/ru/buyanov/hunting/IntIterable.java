package ru.buyanov.hunting;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *  @author https://github.com/alex-on-java 03.02.2016
 */
public class IntIterable implements Iterable<Integer> {
    private int[] backed;
    private int check;


    public IntIterable(int[] backed) {
        this.backed = backed;
        this.check=0;
    }

    public Iterator<Integer> iterator() {
        return new IntIterator();
    }

    private class IntIterator implements Iterator<Integer> {

        public boolean hasNext() {
            //если check меньше длины массива, то метод вернет true, если больше или равен - false, то есть следующего элемента не существует
            return check<backed.length;
        }

        public Integer next() {
            //TODO: You task is implement this method
            //если hasNext() возвращает истину, то метод next() вернет следующий элемент массива backed
            if(hasNext())
            {
                return backed[check++];
            } else
            //однако, если следующего элемента не имеется, то вместо Integer'а, метод выбрасывает исключение об отсутствии элемента
            {
                throw new NoSuchElementException();
            }
        }
        //юнит тесты выполняются успешно

        public void remove() {
            throw new IllegalStateException("Could not remove from array");
        }
    }
}
