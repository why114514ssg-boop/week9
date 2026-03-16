import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class RallyRaceResult implements RaceResult {
    private final String raceName;
    private final String location;
    private final Map<Driver, Integer> results;

    public RallyRaceResult(String raceName, String location) {
        this.raceName = raceName;
        this.location = location;
        this.results = new LinkedHashMap<>();
    }

    @Override
    public void recordResult(Driver driver, int position, int points) {
        results.put(driver, points);
        driver.addPoints(points);
    }

    @Override
    public Map<Driver, Integer> getResults() {
        return results;
    }

    public void printResults() {
        System.out.println("Race: " + raceName + " (" + location + ")");
        int pos = 1;
        for (Entry<Driver, Integer> entry : results.entrySet()) {
            System.out.printf("Position %d: %s - %d points%n",
                    pos, entry.getKey().getName(), entry.getValue());
            pos++;
        }
    }
}
