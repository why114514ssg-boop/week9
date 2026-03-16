public class Driver {
    private final String name;
    private final String country;
    private int totalPoints;
    private RallyCar car;

    public Driver(String name, String country, RallyCar car) {
        this.name = name;
        this.country = country;
        this.car = car;
        this.totalPoints = 0;
    }

    public void addPoints(int points) {
        this.totalPoints += points;
    }

    public void setCar(RallyCar car) {
        this.car = car;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public RallyCar getCar() {
        return car;
    }
}
