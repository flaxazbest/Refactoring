package videostore;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Customer {

    private String name;
    private List<Rental> rentals = new LinkedList<Rental>();

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Iterator<Rental> rents = rentals.iterator();
        StringBuilder result = new StringBuilder();
        result.append("Звіт аренди для ").append(getName()).append("\n");
        while (rents.hasNext()) {
            Rental each = (Rental)rents.next();

            frequentRenterPoints += each.getFrequentRenterPoints();

            result.append("\t").append(each.getMovie().getTitle())
                   .append("\t").append(String.valueOf(each.getCharge()))
                   .append("\n");

            totalAmount += each.getCharge();
        }

        result.append("Сума заборгованості складає ").append(String.valueOf(totalAmount)).append("\n")
              .append("Ви заробили ").append(String.valueOf(frequentRenterPoints))
              .append(" балів за активність");

        return result.toString();
    }

    private double amountFor(Rental rental) {
        return rental.getCharge();
    }
}
