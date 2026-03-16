import java.util.Map;

public interface RaceResult {
    Map<Driver, Integer> getResults();
    void recordResult(Driver driver, int position, int points);
}
