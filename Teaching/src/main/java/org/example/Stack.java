package org.example;

public class Stack <T> {
    private int i;
    private int maxSize;

    private int size;

    private T[] mas;

    public Stack(int maxSize) {
        this.maxSize = maxSize;

        mas = (T[]) new Object[maxSize];
        size = 0;
        i = 0;
    }

    public void push(T newElem) {
        if(size < maxSize) {
            mas[i] = newElem;

            i++;

            size++;
        }
    }

    public T pop() {
        if(size > 0) {
            T a = mas[i - 1];
            i--;
            size--;

            return a;
        }

        return null;
    }

    public T look() {
        if(size > 0) {
            return mas[i - 1];
        }

        return null;
    }

    public int getSize() {
        return size;
    }
}
