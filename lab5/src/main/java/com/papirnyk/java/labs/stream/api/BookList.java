package com.papirnyk.java.labs.stream.api;

import java.util.*;
import java.util.function.UnaryOperator;

public class BookList implements List<Book> {

    private List<Book> books;
    private Map<String, Integer> authorBooksMap;

    public BookList() {
        this.books = new ArrayList<>();
        this.authorBooksMap = new HashMap<>();
    }

    public BookList(List<Book> books) {
        this.books = books;
        this.authorBooksMap = new HashMap<>();
    }

    public BookList(List<Book> books, Map<String, Integer> authorBooksMap) {
        this.books = books;
        this.authorBooksMap = authorBooksMap;
    }

    public List<Book> getBooks() {
        return books;
    }

    public Map<String, Integer> getAuthorBooksMap() {
        return authorBooksMap;
    }

    @Override
    public int size() {
        return books.size();
    }

    @Override
    public boolean isEmpty() {
        return books.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return books.contains( o );
    }

    @Override
    public Iterator<Book> iterator() {
        return books.iterator();
    }

    @Override
    public Object[] toArray() {
        return books.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return books.toArray( a );
    }

    @Override
    public boolean add(Book book) {
        boolean add = books.add( book );
        if (add) {
            String author = book.getAuthor();
            authorBooksMap.put( author, countBooks( author ) );
        }
        return add;
    }

    private int countBooks(String author) {
        return (int) books.stream().filter( _book -> _book.getAuthor().equals( author ) ).count();
    }

    @Override
    public boolean remove(Object object) {
        boolean remove = books.remove( object );
        if (remove) {
            Book book = (Book) object;
            String author = book.getAuthor();
            authorBooksMap.put( author, countBooks( author ) );
        }
        return remove;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return books.containsAll( c );
    }

    @Override
    public boolean addAll(Collection<? extends Book> c) {
        return books.addAll( c );
    }

    @Override
    public boolean addAll(int index, Collection<? extends Book> c) {
        return books.addAll( index, c );
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return books.removeAll( c );
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return books.retainAll( c );
    }

    @Override
    public void replaceAll(UnaryOperator<Book> operator) {
        books.replaceAll( operator );
    }

    @Override
    public void sort(Comparator<? super Book> c) {
        books.sort( c );
    }

    @Override
    public void clear() {
        books.clear();
        authorBooksMap.clear();
    }

    @Override
    public boolean equals(Object o) {
        return books.equals( o );
    }

    @Override
    public int hashCode() {
        return books.hashCode();
    }

    @Override
    public Book get(int index) {
        return books.get( index );
    }

    @Override
    public Book set(int index, Book element) {
        return books.set( index, element );
    }

    @Override
    public void add(int index, Book element) {
        books.add( index, element );
    }

    @Override
    public Book remove(int index) {
        return books.remove( index );
    }

    @Override
    public int indexOf(Object o) {
        return books.indexOf( o );
    }

    @Override
    public int lastIndexOf(Object o) {
        return books.lastIndexOf( o );
    }

    @Override
    public ListIterator<Book> listIterator() {
        return books.listIterator();
    }

    @Override
    public ListIterator<Book> listIterator(int index) {
        return books.listIterator( index );
    }

    @Override
    public List<Book> subList(int fromIndex, int toIndex) {
        return books.subList( fromIndex, toIndex );
    }

    @Override
    public Spliterator<Book> spliterator() {
        return books.spliterator();
    }
}
