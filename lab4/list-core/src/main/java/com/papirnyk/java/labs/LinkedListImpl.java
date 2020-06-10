package com.papirnyk.java.labs;

public class LinkedListImpl<T> implements IList<T> {

    private Node<T> root;
    private int size;

    private static class Node<T> {
        private T data;
        private Node<T> next;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T getElement(int index) {
        checkElementIndex( index );
        Node<T> current = root;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    @Override
    public void insert(int index, T element) {
        checkElementIndex( index );
        if (root == null) {
            add( element );
        } else {
            Node<T> current = root;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            Node<T> next = current.next;

            Node<T> insertNode = new Node<>();
            insertNode.data = element;

            current.next = insertNode;
            insertNode.next = next;
        }
        size++;
    }

    @Override
    public void add(T element) {
        if (root == null) {
            root = new Node<>();
            root.data = element;
        } else {
            Node<T> current = root;
            while (current.next != null) {
                current = current.next;
            }
            Node<T> next = new Node<>();
            next.data = element;
            current.next = next;
        }
        size++;
    }

    @Override
    public void remove(int index) {
        checkElementIndex( index );

        Node<T> current = root;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        current.next = current.next.next;
        size--;
    }

    @Override
    public void setElement(int index, T element) {
        checkElementIndex( index );
        Node<T> current = root;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.data = element;
    }

    private void checkElementIndex(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException( String.format( "Index: %d, Size: %d", index, size ) );
        }
    }
}
