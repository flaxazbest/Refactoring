package videostore;

public class Client {

    public static void main(String[] args) {
        Movie movie1 = new Movie("Ant man and Wisp", Movie.NEW_RELEASE);
        Movie movie2 = new Movie("Toy story", Movie.CHILDREN);
        Movie movie3 = new Movie("X-man: origin wolverine", Movie.REGULAR);

        Rental rental1 = new Rental(movie1, 5);
        Rental rental2 = new Rental(movie2, 2);
        Rental rental3 = new Rental(movie3, 4);

        Customer client1 = new Customer("Vidos");
        client1.addRental(rental1);
        client1.addRental(rental2);
        client1.addRental(rental3);

        System.out.println(client1.statement());
    }

}
