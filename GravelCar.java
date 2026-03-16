public class GravelCar extends RallyCar {
    private final double suspensionTravel;

    public GravelCar(String make, String model, int horsepower, double suspensionTravel) {
        super(make, model, horsepower);
        this.suspensionTravel = suspensionTravel;
    }

    @Override
    public double calculatePerformance() {
        double powerPart = getHorsepower() * 0.8;
        double suspensionPart = suspensionTravel * 1.5;
        return powerPart + suspensionPart;
    }
}
