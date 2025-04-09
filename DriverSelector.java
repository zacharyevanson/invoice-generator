import java.util.*;
import java.io.*;

public class DriverSelector {
    List<Driver> drivers = new ArrayList<>();
    public List<Driver> readDriversFromFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] item = line.split(", ");
                if (item.length == 3) {
                    String name = item[0].trim();
                    String location = item[1].trim();
                    int ordLoad = Integer.parseInt(item[2].trim());
                    drivers.add(new Driver(name, location, ordLoad));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return drivers;
    }
    public Driver getBestDriver(String location) {
        Driver bestDriver = null;
        
        for (Driver driver : drivers) {
            if (driver.getLocation().equals(location)) {
                if (bestDriver == null || driver.getOrdLoad() < bestDriver.getOrdLoad()) {
                    bestDriver = driver;
                }
            }
         }
         return bestDriver;
    }
}
