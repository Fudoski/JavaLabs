package com.papirnyk.java.labs;


import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ListImplementationsTest {

    @Rule
    public final ExpectedException thrown = ExpectedException.none();

    private IList<Integer> list;

    public ListImplementationsTest(IList<Integer> listImpl) {
        this.list = listImpl;
    }

    @Parameterized.Parameters(name = "{index}: Impl Class: {0}")
    public static Collection<Object[]> getParameters() {
        return Arrays.asList( new Object[][]{
                {new ListImpl<>( 5 )},
                {new LinkedListImpl<>()}
        } );
    }

    @Before
    public void setUp() throws Exception {
        list = new ListImpl<>( 5 );
    }

    @Test
    public void shouldReturnActualSizeOfList() {
        final int expectedSize = 3;

        list.add( 1 );
        list.add( 2 );
        list.add( 3 );

        assertEquals( expectedSize, list.size() );
    }

    @Test
    public void shouldReturnElementByIndexWhenIndexInRange() {
        final int expectedValue = 99;

        list.add( 99 );

        final int actualValue = list.getElement( 0 );
        assertEquals( expectedValue, actualValue );
    }

    @Test
    public void shouldInsertElementAtPositionByIndexWhenIndexInRange() {
        final int expectedSIze = 4;
        final int expectedValue = 10;

        list.add( 1 );
        list.add( 4 );
        list.add( 6 );

        list.insert( 1, 10 );

        assertEquals( expectedSIze, list.size() );
        final int actualValue = list.getElement( 1 );
        assertEquals( expectedValue, actualValue );
    }

    @Test
    public void shouldAddElementAtTheEndOfList() {
        final int expectedSize = 5;
        final int expectedLastElement = expectedSize - 1;
        for (int i = 0; i < expectedSize; i++) {
            list.add( i );
        }

        assertEquals( expectedSize, list.size() );

        final int actualElement = list.getElement( expectedSize - 1 );
        assertEquals( expectedLastElement, actualElement );
    }

    @Test
    public void shouldRemoveElementByIndexWhenIndexIsInRange() {
        final int expectedSIze = 2;
        final int expectedValue = 6;

        list.add( 1 );
        list.add( 4 );
        list.add( 6 );

        list.remove( 1 );

        assertEquals( expectedSIze, list.size() );
        final int actualValue = list.getElement( 1 );
        assertEquals( expectedValue, actualValue );
    }

    @Test
    public void shouldReplaceOldValueAtIndexByNewWhenIndexIsInBounds() {

        final int expectedSIze = 3;
        final int expectedValue = 1337;

        list.add( 1 );
        list.add( 8 );
        list.add( 9 );

        list.setElement( 1, 1337 );

        assertEquals( expectedSIze, list.size() );
        final int actualValue = list.getElement( 1 );
        assertEquals( expectedValue, actualValue );
    }

    @Test
    public void shouldThrownIndexOutOfBoundsExceptionWhenIndexIsNegative() {
        thrown.expect( IndexOutOfBoundsException.class );
        list.remove( -5 );
    }

    @Test
    public void shouldThrownIndexOutOfBoundsExceptionWhenIndexIsMoreThenListSize() {
        thrown.expect( IndexOutOfBoundsException.class );
        list.remove( 2 );

    }
}