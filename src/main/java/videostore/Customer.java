package videostore;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Customer {

    private String name;
    private List<Rental> rentals = new LinkedList<Rental>();

    Customer(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    void addRental(Rental arg) {
        rentals.add(arg);
    }

    String statement() {
        Iterator<Rental> rents = rentals.iterator();
        StringBuilder result = new StringBuilder();
        result.append("Звіт аренди для ").append(getName()).append("\n");
        while (rents.hasNext()) {
            Rental each = rents.next();

            result.append("\t").append(each.getMovie().getTitle())
                   .append("\t").append(String.valueOf(each.getCharge()))
                   .append("\n");
        }

        result.append("Сума заборгованості складає ").append(String.valueOf(getTotalCharge())).append("\n")
              .append("Ви заробили ").append(String.valueOf(getTotalFrequentRenterPoints()))
              .append(" балів за активність");

        return result.toString();
    }

    private double getTotalCharge() {
        double result = 0;
        for (Rental r: rentals)
            result += r.getCharge();
        return result;
    }

    private int getTotalFrequentRenterPoints() {
        int result = 0;
        for (Rental r: rentals)
            result += r.getFrequentRenterPoints();
        return result;
    }
}
