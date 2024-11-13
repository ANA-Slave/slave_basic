package carCompany;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarFactory {

    private final List<Car> carList;

    public CarFactory(String cars) {
        carList = Arrays.stream(cars.split(","))
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public List<Car> getCarList() {
        return carList;
    }

}
