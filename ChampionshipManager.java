import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ChampionshipManager {
    private static volatile ChampionshipManager instance;

    private final List<Driver> drivers;
    private final List<RallyRaceResult> races;

    private static int totalDrivers = 0;
    private static int totalRaces = 0;

    private ChampionshipManager() {
        drivers = new ArrayList<>();
        races = new ArrayList<>();
    }

    public static ChampionshipManager getInstance() {
        if (instance == null) {
            synchronized (ChampionshipManager.class) {
                if (instance == null) {
                    instance = new ChampionshipManager();
                }
            }
        }
        return instance;
    }

    public void registerDriver(Driver driver) {
        if (driver != null) {
            drivers.add(driver);
            totalDrivers = drivers.size();
        }
    }

    public void addRaceResult(RallyRaceResult race) {
        if (race != null) {
            races.add(race);
            totalRaces = races.size();
        }
    }

    public List<Driver> getDrivers() {
        return Collections.unmodifiableList(drivers);
    }

    public List<RallyRaceResult> getRaces() {
        return Collections.unmodifiableList(races);
    }

    public static int getTotalDrivers() {
        return totalDrivers;
    }

    public static int getTotalRaces() {
        return totalRaces;
    }
}
