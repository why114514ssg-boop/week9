import java.util.List;
import java.util.List;
import java.util.Map;
import java.util.HashMap; 
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
// 统计锦标赛领先车手
public static Driver getChampionshipLeader() {
    ChampionshipManager manager = ChampionshipManager.getInstance();
    List<Driver> drivers = manager.getDrivers();
    Driver leader = null;
    int maxPoints = 0;
    for (Driver d : drivers) {
        if (d.getTotalPoints() > maxPoints) {
            maxPoints = d.getTotalPoints();
            leader = d;
        }
    }
    return leader;
}

public static String getMostSuccessfulCountry() {
    ChampionshipManager manager = ChampionshipManager.getInstance();
    List<Driver> drivers = manager.getDrivers();
    Map<String, Integer> countryPoints = new HashMap<>();
    for (Driver d : drivers) {
        String country = d.getCountry();
        countryPoints.put(country, countryPoints.getOrDefault(country, 0) + d.getTotalPoints());
    }
    String topCountry = null;
    int maxTotal = 0;
    for (Map.Entry<String, Integer> entry : countryPoints.entrySet()) {
        if (entry.getValue() > maxTotal) {
            maxTotal = entry.getValue();
            topCountry = entry.getKey();
        }
    }
    return topCountry;
}
