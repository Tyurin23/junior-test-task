package ru.buyanov.hunting;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *  @author https://github.com/alex-on 03.02.2016
 *  @author John https://github.com/BlackNWh1te 31.07.2016
 */
public  class  IntIterable  implements Iterable<Integer> {

    private int[] backed;


    public IntIterable(int [] backed) {
        if (backed == null) throw  new NullPointerException();
                this.backed = backed;
    }

    public Iterator<Integer> iterator() {
        return new IntIterator();
    }

    private class IntIterator implements Iterator<Integer> {

        private boolean removeBlocker;

        private int iteratorPosition;

        private IntIterator(){this.iteratorPosition = 0; this.removeBlocker = true;}

        public boolean hasNext() {
            return backed.length > iteratorPosition;

        }


        public Integer next() {
            try{

                int nextInt = backed[iteratorPosition++];
                removeBlocker = false;
                return nextInt;

            } catch (ArrayIndexOutOfBoundsException e) {throw new NoSuchElementException();}


        }


        /**
         * Попытка реализовать метод {@code remove()}
         * С большим кол-вом элементов будет медленной, но работает
         */
        public void remove() {
            if(!removeBlocker){
                backed = arrayShifter(backed, --iteratorPosition);
                removeBlocker = true;
            }

            else throw new IllegalStateException();

        }

        /**
         * Создаем копию массива -> копируем в нее все элементы, кроме удаляемого
         *
         * @param  original - копируемый массив
         *
         * @param keyPosition - позиция удаляемого элемента
         *
         */
        private int[] arrayShifter(int [] original, int keyPosition){

            int [] newArray =  new int[original.length -1];

            for (int i = 0, k = 0; i< newArray.length; i++, k++) {

                if( k == keyPosition) {i--; continue; }
                newArray[i] = original[k];

            }
            return newArray;
        }
    }
}