package ProjectAston.TypesOfSorting.SortingForCars;

import ProjectAston.*;

import java.util.*;

public class SortByDouble implements Comparator<Car> {

    @Override
    public int compare(Car o1, Car o2) {
        return o1.getPower().compareTo(o2.getPower());
    }

}
