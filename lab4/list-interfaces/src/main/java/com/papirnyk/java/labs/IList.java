package com.papirnyk.java.labs;

public interface IList<T> {
    int size();

    T getElement(int index);

    void insert(int index, T element);

    void add(T element);

    void remove(int index);

    void setElement(int index, T element);
}
