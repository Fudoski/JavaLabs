package com.papirnyk.java.labs;

import java.util.Arrays;

public class ListImpl<T> implements IList<T>{

    protected Object[] elements;
    protected int size;

    public ListImpl(int capacity) {
        elements = new Object[capacity];
    }

    private void checkIndexRange(int index){
        if(index > size || index < 0){
            throw new ArrayIndexOutOfBoundsException("Index was out of range");
        }
    }

    private void increaseArrayLength(){
        elements = Arrays.copyOf(elements, elements.length *2);
    }

    private void checkListLength(){
        if(size + 1 == elements.length){
            increaseArrayLength();
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T getElement(int index) {
        checkIndexRange(index);
        return (T) elements[index];
    }

    @Override
    public void insert(int index, T element) {
        checkIndexRange(index);
        checkListLength();
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;
        size++;
    }

    @Override
    public void add(T element) {
        checkListLength();
        elements[size++] = element;
    }

    @Override
    public void remove(int index) {
        checkIndexRange(index);
        System.arraycopy(elements, index + 1, elements, index, size - index);
        elements[size--] = null;

    }

    @Override
    public void setElement(int index, T element) {
        checkIndexRange(index);
        elements[index] = element;
    }
}
