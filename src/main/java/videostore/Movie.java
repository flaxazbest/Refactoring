package videostore;

class Movie {

    static final int CHILDREN = 2;
    static final int REGULAR = 0;
    static final int NEW_RELEASE = 1;

    private String title;
    private Price price;

    Movie(String title, int priceCode) {
        this.title = title;
        setPriceCode(priceCode);
    }

    private void setPriceCode(int arg) {
        switch (arg) {
            case REGULAR:
                price = new RegularPrice();
                break;
            case NEW_RELEASE:
                price = new NewReleasePrice();
                break;
            case CHILDREN:
                price = new ChildrensPrice();
                break;
                default:
                    throw new IllegalArgumentException("Некоректний тип");
        }
    }

    String getTitle() {
        return title;
    }

    double getCharge(int daysRental) {
        return price.getCharge(daysRental);
    }

    int getFrequentRenterPoints(int daysRented) {
        return price.getFrequentRenterPoints(daysRented);
    }
}
