public abstract class RallyCar {
    private final String make;
    private final String model;
    private final int horsepower;

    public RallyCar(String make, String model, int horsepower) {
        this.make = make;
        this.model = model;
        this.horsepower = horsepower;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public String getModel() {
        return model;
    }

    public String getMake() {
        return make;
    }

    public abstract double calculatePerformance();
}
