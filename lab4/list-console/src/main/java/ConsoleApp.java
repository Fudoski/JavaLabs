import com.papirnyk.java.labs.IList;
import com.papirnyk.java.labs.LinkedListImpl;
import com.papirnyk.java.labs.ListImpl;

public class ConsoleApp {

    public static void main(String[] args) {
        // array list
        IList<Integer> integerList = null;
        for (int k = 1; k <= 2; k++) {
            switch (k) {
                case 1:
                    // array list
                    System.out.println( "ListImpl" );
                    integerList = new ListImpl<>( 5 );
                    break;
                case 2:
                    // linked list
                    System.out.println( "LinkedListImpl" );
                    integerList = new LinkedListImpl<>();
                    break;
            }

            System.out.println( String.format( "%d", integerList.size() ) );
            integerList.add( 1 );
            System.out.println( String.format( "%d", integerList.size() ) );
            integerList.add( 23 );
            integerList.add( 45 );
            System.out.println( String.format( "%d", integerList.getElement( 1 ) ) );
            integerList.insert( 1, 147 );

            for (int i = 0; i < integerList.size(); i++) {
                System.out.println( integerList.getElement( i ) );
            }

            integerList.remove( 3 );
            for (int i = 0; i < integerList.size(); i++) {
                System.out.println( integerList.getElement( i ) );
            }

            integerList.setElement( 2, 200 );
            System.out.println( integerList.getElement( 2 ) );

            System.out.println( "------" );
        }
    }
}
