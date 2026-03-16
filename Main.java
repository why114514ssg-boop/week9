public class Main {
    public static void main(String[] args) {
        ChampionshipManager manager = ChampionshipManager.getInstance();

       
        RallyCar asphaltCar = new AsphaltCar("Toyota", "GR Yaris", 300, 1.2);
        RallyCar gravelCar = new GravelCar("Ford", "Fiesta WRC", 280, 0.8);

        
        Driver driver1 = new Driver("Sébastien Ogier", "France", asphaltCar);
        Driver driver2 = new Driver("Kalle Rovanperä", "Finland", gravelCar);
        Driver driver3 = new Driver("Ott Tänak", "Estonia", asphaltCar);

        manager.registerDriver(driver1);
        manager.registerDriver(driver2);
        manager.registerDriver(driver3);

        RallyRaceResult race1 = new RallyRaceResult("Monte Carlo Rally", "Monaco");
        race1.recordResult(driver1, 1, 25);
        race1.recordResult(driver3, 2, 18);
        race1.recordResult(driver2, 3, 15);
        manager.addRaceResult(race1);

        driver2.setCar(asphaltCar);

        RallyRaceResult race2 = new RallyRaceResult("Sweden Rally", "Sweden");
        race2.recordResult(driver2, 1, 25);
        race2.recordResult(driver1, 2, 18);
        race2.recordResult(driver3, 3, 15);
        manager.addRaceResult(race2);

        System.out.println("=== Race Results ===");
        race1.printResults();
        race2.printResults();

        System.out.println("\n=== Championship Statistics ===");
        System.out.println("Total Drivers: " + ChampionshipManager.getTotalDrivers());
        System.out.println("Total Races: " + ChampionshipStatistics.countTotalRacesHeld());
        System.out.printf("Average Points per Driver: %.2f%n", ChampionshipStatistics.calculateAveragePointsPerDriver());
        System.out.println("Most Successful Country: " + ChampionshipStatistics.getMostSuccessfulCountry());
        Driver leader = ChampionshipStatistics.getChampionshipLeader();
        System.out.println("\n===== CHAMPIONSHIP LEADER =====");
        System.out.printf("%s with %d points%n", leader.getName(), leader.getTotalPoints());

        System.out.println("\n=== Driver Standings ===");
        for (Driver driver : manager.getDrivers()) {
            System.out.printf("%s (%s): %d points | Car Performance: %.2f%n",
                    driver.getName(), driver.getCountry(),
                    driver.getTotalPoints(), driver.getCar().calculatePerformance());
        }
    }
}
