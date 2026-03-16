import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ChampionshipManager {

    private static volatile ChampionshipManager singletonInstance;

    private final List<Driver> driverList;
    private final List<RallyRaceResult> raceResults;

    private static int registeredDriverCount = 0;
    private static int completedRaceCount = 0;

    private ChampionshipManager() {
        driverList = new ArrayList<>();
        raceResults = new ArrayList<>();
    }

    public static ChampionshipManager getInstance() {
        if (singletonInstance == null) {
            synchronized (ChampionshipManager.class) {
                if (singletonInstance == null) {
                    singletonInstance = new ChampionshipManager();
                }
            }
        }
        return singletonInstance;
    }

    public void registerDriver(final Driver driver) {
        if (driver != null) {
            driverList.add(driver);
            registeredDriverCount = driverList.size();
        }
    }

    public void addRaceResult(final RallyRaceResult race) {
        if (race != null) {
            raceResults.add(race);
            completedRaceCount = raceResults.size();
        }
    }

    public List<Driver> getDrivers() {
        return Collections.unmodifiableList(driverList);
    }

    public List<RallyRaceResult> getRaces() {
        return Collections.unmodifiableList(raceResults);
    }

    public static int getTotalDrivers() {
        return registeredDriverCount;
    }

    public static int getTotalRaces() {
        return completedRaceCount;
    }
}
