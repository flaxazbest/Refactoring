package videostore;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerTest {

    Movie movie1;
    Movie movie2;
    Movie movie3;

    Rental rental1;
    Rental rental2;
    Rental rental3;

    Customer client1;

    @Before
    public void init() {
        movie1 = new Movie("Ant man and Wisp", Movie.NEW_RELEASE);
        movie2 = new Movie("Toy story", Movie.CHILDREN);
        movie3 = new Movie("X-man: origin wolverine", Movie.REGULAR);

        rental1 = new Rental(movie1, 5);
        rental2 = new Rental(movie2, 2);
        rental3 = new Rental(movie3, 4);

        client1 = new Customer("Vidos");
        client1.addRental(rental1);
        client1.addRental(rental2);
        client1.addRental(rental3);
    }

    @Test
    public void statement() {

        String result = "Звіт аренди для Vidos\n" +
                "\tAnt man and Wisp\t15.0\n" +
                "\tToy story\t1.5\n" +
                "\tX-man: origin wolverine\t5.0\n" +
                "Сума заборгованості складає 21.5\n" +
                "Ви заробили 4 балів за активність";

        assertEquals(client1.statement(), result);

    }
}