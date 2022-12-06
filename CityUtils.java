import java.io.File;
import java.io.FileNotFoundException;
import java.text.MessageFormat;
import java.util.*;

public class CityUtils {
    public static List<City> parse() {
        List<City> cities = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File("src\\city_ru.csv"));
            while (scanner.hasNextLine()) {
                cities.add(parse(scanner.nextLine()));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return cities;
    }

    private static City parse(String line) {
        Scanner scanner = new Scanner(line);
        scanner.useDelimiter(";");
        scanner.skip("\\d*");
        String name = scanner.next();
        String region = scanner.next();
        String district = scanner.next();
        int population = scanner.nextInt();
        String foundation = null;
        if (scanner.hasNext()) {
            foundation = scanner.next();
        }
        scanner.close();

        return new City(name, region, district, population, foundation);
    }

    public static void findCityWithMaxPopulation (List<City> cities) {
        City[] arrayOfCities = new City[cities.size()];
        cities.toArray(arrayOfCities);
        int maxPopulation = arrayOfCities[0].getPopulation();
        int index = 0;
        for(int i = 1; i < arrayOfCities.length; i++) {
            if(maxPopulation <  arrayOfCities[i].getPopulation()) {
                maxPopulation = arrayOfCities[i].getPopulation();
                index = i;
            }
        }
        System.out.println(MessageFormat.format("[{0}] = {1}", index, maxPopulation));
    }



}


