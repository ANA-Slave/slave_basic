import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CarService {

    private List<Car> cars;

    public CarService(List<String> carNames) {
        this.cars = new ArrayList<>();
        for(String name : carNames) {
            this.cars.add(new Car(name));
        }
    }

    public void moveCars() {
        RandomGenerator randomGenerator = new RandomGenerator();
        for(Car car : cars) {
            car.move(randomGenerator);
        }
    }

    public List<Car> getWinners() {
        List<Car> winners = new ArrayList<>();
        int maxLocation = cars.stream().max(Comparator.comparingInt(Car::getLocation)).map(Car::getLocation).orElse(0);

        for(Car car : cars) {
            if(car.getLocation() == maxLocation) {
                winners.add(car);
            }
        }
        return winners;
    }

    public List<Car> getCars() {
        return cars;
    }
}
