public class AsphaltCar extends RallyCar {
    private final double tireGrip;

    public AsphaltCar(String make, String model, int horsepower, double tireGrip) {
        super(make, model, horsepower);
        this.tireGrip = tireGrip;
    }

    @Override
    public double calculatePerformance() {
        double powerContribution = getHorsepower() * 0.9;
        double gripContribution = tireGrip * 2.0;
        return powerContribution + gripContribution;
    }
}
