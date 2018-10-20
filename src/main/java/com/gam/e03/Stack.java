package com.gam.e03;

public class Stack {

    private int capacity;
    private int[] elements;
    private int size;

    public Stack(int capacity) {
        this.capacity = capacity;
        elements = new int[capacity];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(int element) {
        if (size == capacity)
            throw new StackOverflowException();

        elements[size++] = element;
    }

    public int size() {
        return size;
    }

    public int pop() {
        if (size == 0)
            throw new EmptyStackException();

        return elements[--size];
    }

    public static class StackOverflowException extends RuntimeException {

    }

    public static class EmptyStackException extends RuntimeException {

    }
}
