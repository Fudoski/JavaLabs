package com.papirnyk.java.labs.stream.api;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {

    public static final String TASK_SPLITTER = "--------";

    public static void main(String[] args) {
        System.out.println( "Задание 1" );
        List<Integer> integerList = new ArrayList<>();
        integerList.add( 1 );
        integerList.add( 2 );
        integerList.add( 3 );
        integerList.add( 44 );

        System.out.println( integersToString( integerList ) );

        System.out.println( TASK_SPLITTER );
        System.out.println( "Задание 2" );

        List<City> cities = new ArrayList<>();
        cities.add( new City( "Днепр", "Дн обл.", 1_000_000L ) );
        cities.add( new City( "Кривой рог", "Дн обл.", 634_000L ) );
        cities.add( new City( "Новомосковск", "Дн обл.", 70_000L ) );
        cities.add( new City( "Вышгород", "Киев обл.", 23_000L ) );
        cities.add( new City( "Киев", "Киев обл.", 2_884_000L ) );
        cities.add( new City( "Харьков", "Харьков обл.", 1_419_000L ) );
        cities.add( new City( "Чугуев", "Харьков обл.", 33_000L ) );

        Map<String, City> cityMap = getLargestCityPerState( cities );
        cityMap.forEach( (s, city) -> System.out.println( String.format( "State: %s, City: %s, Population: %d", s, city.getName(), city.getPopulation() ) ) );

        System.out.println( TASK_SPLITTER );
        System.out.println( "Задание 3" );

        Stream<Integer> zipStream = zip( Stream.of( 1, 3, 5, 7 ), Stream.of( 2, 4 ) );
        System.out.println( zipStream.map( Object::toString ).collect( Collectors.joining( "," ) ) );

        System.out.println(TASK_SPLITTER);
        System.out.println("Задание 4");

        BookList bookList = new BookList(  );
        bookList.add( new Book( "harry potter and the philosopher's stone", "Джоан Роулинг", "9780545069670" ) );
        Book hpAndOp = new Book( "harry potter and the order of the phoenix", "Джоан Роулинг", "9788867155996" );
        bookList.add( new Book( "маленькие трагедии", "Александр Сергеевич Пушкин", "9785760000361" ) );
        bookList.add( new Book( "евгений онегин", "Александр Сергеевич Пушкин", "9781847491602" ) );

        Map<String, Integer> authorBooksMap = bookList.getAuthorBooksMap();
        authorBooksMap.forEach( (author, booksCount) -> System.out.println(String.format( "Author: %s, books: %d", author, booksCount )) );

        System.out.println();
        bookList.add( hpAndOp );
        System.out.println("Add harry potter and the order of the phoenix");
        authorBooksMap.forEach( (author, booksCount) -> System.out.println(String.format( "Author: %s, books: %d", author, booksCount )) );

        System.out.println();
        System.out.println("Remove harry potter and the order of the phoenix from list" );
        bookList.remove( hpAndOp );
        authorBooksMap.forEach( (author, booksCount) -> System.out.println(String.format( "Author: %s, books: %d", author, booksCount )) );



    }

    private static String integersToString(List<Integer> integers) {
        return integers.stream().map( App::convertInt ).collect( Collectors.joining( "," ) );
    }

    private static Map<String, City> getLargestCityPerState(Collection<City> cities) {
        return cities.stream().collect( Collectors.toMap( City::getState, Function.identity(), BinaryOperator.maxBy( Comparator.comparingLong( City::getPopulation ) ) ) );
    }

    private static String convertInt(int value) {
        if (value % 2 == 0) {
            return String.format( "e%d", value );
        }
        return String.format( "o%d", value );
    }

    private static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        Iterator<T> firstIterator = first.iterator();
        Iterator<T> secondIterator = second.iterator();
        Stream.Builder<T> builder = Stream.builder();

        while (firstIterator.hasNext() && secondIterator.hasNext()) {
            builder.add( firstIterator.next() );
            builder.add( secondIterator.next() );
        }

        return builder.build();
    }

}
