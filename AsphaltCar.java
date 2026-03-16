public class AsphaltCar extends RallyCar {
    private final double tireGrip;

    public AsphaltCar(final String make, final String model, final int horsepower, final double tireGrip) {
        super(make, model, horsepower);
        this.tireGrip = tireGrip;
    }

    @Override
    public double calculatePerformance() {
        final double horsepowerFactor = 0.9;
        final double tireGripFactor = 2.0;
        final double horsepowerContribution = getHorsepower() * horsepowerFactor;
        final double tireGripContribution = tireGrip * tireGripFactor;
        return horsepowerContribution + tireGripContribution;
    }
}
