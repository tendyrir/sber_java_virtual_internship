import java.text.MessageFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<City> cities = CityUtils.parse();
        numberCitiesInRegion(cities);
    }

    public static void sortedByName(List<City> cities) {
        cities.sort(new Comparator<City>() {
            @Override
            public int compare(City o1, City o2) {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        });
    }

    public static void sortedByDistrictAndName(List<City> cities) {
        cities.sort(Comparator.comparing(City::getDistrict).thenComparing(City::getName));
    }

    public static void print(List<City> cities) {
        cities.forEach(System.out::println);
    }

    public static void numberCitiesInRegion(List<City> cities) {
        Map<String, Integer> map = new HashMap<>();
        Integer count = 0;
        String currentRegion = cities.get(0).getRegion();
        for(City element: cities) {
            if (!currentRegion.equals(element.getRegion())) {
                map.put(currentRegion, count);
                count = 0;
            }
            count++;
            currentRegion = element.getRegion();
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}