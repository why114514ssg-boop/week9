import java.util.List;

public final class ChampionshipStatistics {
    public static double calculateAveragePointsPerDriver() {
        ChampionshipManager manager = ChampionshipManager.getInstance();
        List<Driver> driverList = manager.getDrivers();

        if (driverList.isEmpty()) {
            return 0.0;
        }

        int total = 0;
        for (Driver driver : driverList) {
            total += driver.getTotalPoints();
        }
        return (double) total / driverList.size();
    }

    public static int countTotalRacesHeld() {
        return ChampionshipManager.getTotalRaces();
    }
}
