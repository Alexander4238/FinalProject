package ProjectAston.TypesOfSorting.SortingForCars;

import ProjectAston.*;
import java.util.Comparator;

public class SortByString implements Comparator<Car> {
    @Override
    public int compare(Car o1, Car o2) {
        return o1.getModel().compareTo(o2.getModel());
    }

}
